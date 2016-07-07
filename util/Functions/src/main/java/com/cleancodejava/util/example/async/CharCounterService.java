package com.cleancodejava.util.example.async;

import com.cleancodejava.util.function.AsyncFunction;
import com.cleancodejava.util.function.Consumer;

public class CharCounterService implements AsyncFunction<String, Integer>{

	@Override
	public void apply(String input, Consumer<Integer> output) {
		output.accept(input.length());
	}

}
