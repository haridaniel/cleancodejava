package com.cleancodejava.util.example.async;

import com.cleancodejava.util.asyncchain.AsyncFunctionProxy;
import com.cleancodejava.util.function.AsyncFunction;
import com.cleancodejava.util.function.Consumer;

public class LoggerProxy<T, R> implements AsyncFunctionProxy<T, R> {

	@Override
	public void apply(T input, Consumer<R> output, AsyncFunction<T, R> target) {
		System.out.println("Proxy: input=" + input);
		target.apply(input, new Consumer<R>() {
			@Override
			public void accept(R t) {
				System.out.println("Proxy: output=" + t);
				output.accept(t);
			}
		});
	}
	
}
