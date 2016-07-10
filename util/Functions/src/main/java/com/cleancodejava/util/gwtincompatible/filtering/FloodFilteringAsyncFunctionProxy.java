package com.cleancodejava.util.gwtincompatible.filtering;

import com.cleancodejava.util.filtering.BaseFloodFilterFunctionProxy;

/**
 * Uses JavaTimer as a timer.
 */
public class FloodFilteringAsyncFunctionProxy<T, R> extends BaseFloodFilterFunctionProxy<T, R> {

	public FloodFilteringAsyncFunctionProxy(int delayMS) {
		super(new JavaTimer(), delayMS);
	}

	
}
