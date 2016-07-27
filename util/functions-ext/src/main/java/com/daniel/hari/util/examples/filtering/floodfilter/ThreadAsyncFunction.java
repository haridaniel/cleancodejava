package com.daniel.hari.util.examples.filtering.floodfilter;

import com.daniel.hari.util.function.AsyncFunction;
import com.daniel.hari.util.function.Consumer;

public abstract class ThreadAsyncFunction<T, R> implements AsyncFunction<T, R> {

	@Override
	public final void apply(T input, Consumer<R> callback) {
		new Thread(() -> 
			applyInNewThread(input, callback)
		).start();
	}

	private void applyInNewThread(T input, Consumer<R> callback) {
		callback.accept(doApply(input));
	}

	protected abstract R doApply(T input);

}
