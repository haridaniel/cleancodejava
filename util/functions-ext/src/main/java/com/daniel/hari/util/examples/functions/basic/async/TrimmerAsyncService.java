package com.daniel.hari.util.examples.functions.basic.async;

import com.daniel.hari.util.function.AsyncFunction;
import com.daniel.hari.util.function.Consumer;

public class TrimmerAsyncService implements AsyncFunction<String, String> {

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
