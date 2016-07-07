package com.cleancodejava.util.example.async;

import com.cleancodejava.util.function.AsyncFunction;
import com.cleancodejava.util.function.Consumer;

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
