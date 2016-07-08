package com.cleancodejava.util.examples.functions.basic.async;

import com.cleancodejava.util.functions.function.AsyncFunction;
import com.cleancodejava.util.functions.function.Consumer;

public class CharCounterService implements AsyncFunction<String, Integer>{

	@Override
	public void apply(String input, Consumer<Integer> output) {
		output.accept(input.length());
	}

}
