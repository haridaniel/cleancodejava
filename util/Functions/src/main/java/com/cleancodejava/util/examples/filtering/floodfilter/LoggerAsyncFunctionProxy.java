package com.cleancodejava.util.examples.filtering.floodfilter;

public class LoggerAsyncFunctionProxy<T, R> extends SpyAsyncFunctionProxy<T, R> {

	@Override
	protected void onApply(T input) {
		System.out.println("Apply: " + input);
	}

	@Override
	protected void onResult(T input, R result) {
		System.out.println("RESULT: " + input + "->" + result);
	}

}
