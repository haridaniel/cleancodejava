package com.cleancodejava.util.examples.filtering.floodfilter;

public class UppercaseAsyncFunction extends ThreadAsyncFunction<String, String> {
	private int sleepMillis;

	public UppercaseAsyncFunction(int sleepMillis) {
		this.sleepMillis = sleepMillis;
	}
	
	@Override
	protected String doApply(String input) {
		sleep();
		return input.toUpperCase();
	}

	private void sleep() {
		try {
			Thread.sleep(sleepMillis);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}


}
