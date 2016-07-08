package com.cleancodejava.util.examples.functions.basic.async;

import com.cleancodejava.util.functions.asyncchain.AbstractAsyncFunctionProxy;
import com.cleancodejava.util.functions.function.Consumer;

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
