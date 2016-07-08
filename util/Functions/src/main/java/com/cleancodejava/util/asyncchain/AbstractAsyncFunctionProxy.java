package com.cleancodejava.util.asyncchain;

import com.cleancodejava.util.function.AsyncFunction;

public abstract class AbstractAsyncFunctionProxy<T, R> implements AsyncFunctionProxy<T, R> {
	protected AsyncFunction<T, R> target;

	@Override
	public void setTarget(AsyncFunction<T, R> target) {
		this.target = target;
	}

}
