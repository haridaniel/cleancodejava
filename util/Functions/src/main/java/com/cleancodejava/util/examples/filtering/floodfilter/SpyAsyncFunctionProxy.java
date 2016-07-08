package com.cleancodejava.util.examples.filtering.floodfilter;

import com.cleancodejava.util.functions.asyncchain.AbstractAsyncFunctionProxy;
import com.cleancodejava.util.functions.function.Consumer;

public abstract class SpyAsyncFunctionProxy<T, R> extends AbstractAsyncFunctionProxy<T, R> {
	
	@Override
	public void apply(T input, final Consumer<R> callback) {
		onApply(input);
		getTarget().apply(input, new InnerCallback(input, callback));
	}
	
	protected abstract void onApply(T input);
	protected abstract void onResult(T input, R result);
	
	private class InnerCallback implements Consumer<R> {
		private T input;
		private Consumer<R> callback;

		public InnerCallback(T input, Consumer<R> callback) {
			this.input = input;
			this.callback = callback;
		}
		
		@Override
		public void accept(R result) {
			onResult(input, result);
			callback.accept(result);
		}
	}
	
}
