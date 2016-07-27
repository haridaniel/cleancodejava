package com.daniel.hari.util.examples.functions.basic.async;

import com.daniel.hari.util.function.Function;

public class TrimmerService implements Function<String, String> {

	@Override
	public String apply(String t) {
		sleep();
		return t.trim();
	}
	
	private void sleep() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

}
