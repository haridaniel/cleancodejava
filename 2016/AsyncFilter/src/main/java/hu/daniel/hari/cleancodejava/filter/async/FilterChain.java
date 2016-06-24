package hu.daniel.hari.cleancodejava.filter.async;

import java.util.Arrays;
import java.util.Iterator;

public class FilterChain<T> {
	private FilterOutput<T> finalFilterOutput;
	private FilterWrapper<T> filterWrapper;
	
	@SafeVarargs
	public FilterChain(FilterOutput<T> filterOutput, Filter<T>... filters) {
		this.finalFilterOutput = filterOutput;
		assertMinimumOne(filters);
		filterWrapper = new FilterWrapperBuilder().build(Arrays.asList(filters).iterator());
	}

	private void assertMinimumOne(Filter<T>... filters) {
		if(filters.length < 1)
			throw new RuntimeException("No filter provided, while the minimum is one.");
	}

	public void filter(T input) {
		filterWrapper.filter(input);
	}

	private class FilterWrapperBuilder {
		private Iterator<Filter<T>> iterator;

		public FilterWrapper<T> build(Iterator<Filter<T>> iterator) {
			this.iterator = iterator;
			return new FilterWrapper<>(iterator.next(), nextFilterOutput());
		}

		private FilterOutput<T> nextFilterOutput() {
			if(iterator.hasNext())
				return new ChainFilterOutput<>(iterator.next(), nextFilterOutput());
			else
				return finalFilterOutput;
		}
	}
	
	private static class FilterWrapper<T> {
		private Filter<T> filter;
		private FilterOutput<T> filterOutput;
		
		public FilterWrapper(Filter<T> filter, FilterOutput<T> filterOutput) {
			this.filter = filter;
			this.filterOutput = filterOutput;
		}
		
		public void filter(T value) {
			filter.filter(value, filterOutput);
		}
	}
	
	private static class ChainFilterOutput<T> implements FilterOutput<T> {
		private Filter<T> nextFilter;
		private FilterOutput<T> nextFilterOutput;
		
		public ChainFilterOutput(Filter<T> nextFilter, FilterOutput<T> nextFilterOutput) {
			this.nextFilter = nextFilter;
			this.nextFilterOutput = nextFilterOutput;
		}
		@Override
		public void filtered(T value) {
			nextFilter.filter(value, nextFilterOutput);
		}
	}
	
}
