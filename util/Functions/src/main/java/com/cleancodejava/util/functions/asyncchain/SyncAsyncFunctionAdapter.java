package com.cleancodejava.util.functions.asyncchain;

import com.cleancodejava.util.functions.function.AsyncFunction;
import com.cleancodejava.util.functions.function.Consumer;
import com.cleancodejava.util.functions.function.Function;

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
