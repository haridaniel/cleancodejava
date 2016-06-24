package hu.daniel.hari.cleancodejava.filter.async.impls;

import hu.daniel.hari.cleancodejava.filter.async.Filter;
import hu.daniel.hari.cleancodejava.filter.async.FilterOutput;

public class UppercaseFilter implements Filter<String> {

	@Override
	public void filter(String input, FilterOutput<String> filterOutput) {
		filterOutput.filtered(input.toUpperCase());
	}

}
