package com.daniel.hari.util.asyncchain;

import com.daniel.hari.util.function.AsyncFunction;
import com.daniel.hari.util.function.Consumer;
import com.daniel.hari.util.function.Function;

class SyncAsyncFunctionAdapter<T, R> implements AsyncFunction<T, R> {
	private Function<T, R> function;

	public SyncAsyncFunctionAdapter(Function<T, R> function) {
		this.function = function;
	}

	@Override
	public void apply(T input, Consumer<R> output) {
		output.accept(function.apply(input));
	}

}
