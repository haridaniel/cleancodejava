package com.cleancodejava.util.examples.functions.basic.async;

import com.cleancodejava.util.functions.function.AsyncFunction;
import com.cleancodejava.util.functions.function.Consumer;

public class TrimmerService implements AsyncFunction<String, String> {

	@Override
	public void apply(String input, Consumer<String> output) {
		sleep();
		output.accept(input.trim());
	}

	private void sleep() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

}
