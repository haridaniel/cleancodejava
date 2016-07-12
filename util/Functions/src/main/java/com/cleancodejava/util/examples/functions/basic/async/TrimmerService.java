package com.cleancodejava.util.examples.functions.basic.async;

import com.cleancodejava.util.functions.function.Function;

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
