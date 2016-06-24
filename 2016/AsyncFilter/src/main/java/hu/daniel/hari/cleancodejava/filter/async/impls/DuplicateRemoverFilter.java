package hu.daniel.hari.cleancodejava.filter.async.impls;

import java.util.Objects;

import hu.daniel.hari.cleancodejava.filter.async.Filter;
import hu.daniel.hari.cleancodejava.filter.async.FilterOutput;

public class DuplicateRemoverFilter<T> implements Filter<T> {
	private T lastInput = null;
	
	@Override
	public void filter(T input, FilterOutput<T> filterOutput) {
		if(!Objects.equals(input, lastInput)) {
			lastInput = input;
			filterOutput.filtered(input);
		}
	}
}
