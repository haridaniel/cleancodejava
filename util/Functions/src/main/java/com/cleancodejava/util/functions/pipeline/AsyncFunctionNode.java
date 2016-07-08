package com.cleancodejava.util.functions.pipeline;

import com.cleancodejava.util.functions.function.AsyncFunction;

class AsyncFunctionNode<T, R> extends AbstractNode<T, R> {
	private AsyncFunction<? super T, R> asyncFunction;

	public AsyncFunctionNode(AsyncFunction<? super T, R> asyncFunction) {
		this.asyncFunction = asyncFunction;
	}

	@Override
	public void accept(T input) {
		asyncFunction.apply(input, output);
	}

}
