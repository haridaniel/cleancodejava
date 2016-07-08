package com.cleancodejava.util.functions.asyncchain;

import com.cleancodejava.util.functions.function.AsyncFunction;

public abstract class AbstractAsyncFunctionProxy<T, R> implements AsyncFunctionProxy<T, R> {
	private AsyncFunction<T, R> target;

	@Override
	public void setTarget(AsyncFunction<T, R> target) {
		this.target = target;
	}
	
	protected AsyncFunction<T, R> getTarget() {
		return target;
	}

}
