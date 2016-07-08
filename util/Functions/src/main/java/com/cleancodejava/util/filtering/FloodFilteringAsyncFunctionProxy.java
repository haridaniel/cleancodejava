package com.cleancodejava.util.filtering;

/**
 * Uses JavaTimer as a timer.
 */
public class FloodFilteringAsyncFunctionProxy<T, R> extends BaseFloodFilterFunctionProxy<T, R> {

	public FloodFilteringAsyncFunctionProxy(int delayMS) {
		super(new JavaTimer(), delayMS);
	}

	
}
