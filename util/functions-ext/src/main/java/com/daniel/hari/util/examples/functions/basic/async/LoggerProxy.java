package com.daniel.hari.util.examples.functions.basic.async;

import com.daniel.hari.util.asyncchain.AbstractAsyncFunctionProxy;
import com.daniel.hari.util.function.Consumer;

public class LoggerProxy<T, R> extends AbstractAsyncFunctionProxy<T, R> {

	@Override
	public void apply(T input, Consumer<R> output) {
		System.out.println("Proxy: input=" + input);
		getTarget().apply(input, new Consumer<R>() {
			@Override
			public void accept(R t) {
				System.out.println("Proxy: output=" + t);
				output.accept(t);
			}
		});
	}

}
