package com.daniel.hari.util.examples.functions.basic.async;

import com.daniel.hari.util.function.AsyncFunction;
import com.daniel.hari.util.function.Consumer;

public class CharCounterService implements AsyncFunction<String, Integer>{

	@Override
	public void apply(String input, Consumer<Integer> output) {
		output.accept(input.length());
	}

}
