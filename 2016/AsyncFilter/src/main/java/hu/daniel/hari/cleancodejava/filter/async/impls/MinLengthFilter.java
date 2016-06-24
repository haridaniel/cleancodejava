package hu.daniel.hari.cleancodejava.filter.async.impls;

import hu.daniel.hari.cleancodejava.filter.async.Filter;
import hu.daniel.hari.cleancodejava.filter.async.FilterOutput;

public class MinLengthFilter implements Filter<String> {
	private int minLength;

	public MinLengthFilter(int minLength) {
		this.minLength = minLength;
	}

	@Override
	public void filter(String input, FilterOutput<String> filterOutput) {
		if(input.length() >= minLength)
			filterOutput.filtered(input);
	}
}
