package com.cleancodejava.util.asyncchain;

import com.cleancodejava.util.function.AsyncFunction;
import com.cleancodejava.util.function.Consumer;

public interface AsyncFunctionProxy<T, R> {
	
	void setTarget(AsyncFunction<T, R> target);
	
	void apply(T input, Consumer<R> output);
}
