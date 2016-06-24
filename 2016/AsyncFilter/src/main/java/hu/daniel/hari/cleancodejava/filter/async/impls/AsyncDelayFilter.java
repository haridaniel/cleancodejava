package hu.daniel.hari.cleancodejava.filter.async.impls;

import hu.daniel.hari.cleancodejava.filter.async.Filter;
import hu.daniel.hari.cleancodejava.filter.async.FilterOutput;

public class AsyncDelayFilter<T> implements Filter<T> {
	private int millis;

	public AsyncDelayFilter(int millis) {
		this.millis = millis;
	}

	@Override
	public void filter(T input, FilterOutput<T> filterOutput) {
		new Thread(() -> 
			doFilter(input, filterOutput)
		).start();
	}

	private void doFilter(T input, FilterOutput<T> filterOutput) {
		sleep();
		filterOutput.filtered(input);
	}

	private void sleep() {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
