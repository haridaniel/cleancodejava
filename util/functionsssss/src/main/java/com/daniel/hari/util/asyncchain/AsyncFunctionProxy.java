package com.daniel.hari.util.asyncchain;

import com.daniel.hari.util.function.AsyncFunction;
import com.daniel.hari.util.function.Consumer;

public interface AsyncFunctionProxy<T, R> {
	
	void setTarget(AsyncFunction<T, R> target);
	
	void apply(T input, Consumer<R> output);
}
