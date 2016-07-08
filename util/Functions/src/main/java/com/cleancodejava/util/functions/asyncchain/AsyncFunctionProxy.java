package com.cleancodejava.util.functions.asyncchain;

import com.cleancodejava.util.functions.function.AsyncFunction;
import com.cleancodejava.util.functions.function.Consumer;

public interface AsyncFunctionProxy<T, R> {
	
	void setTarget(AsyncFunction<T, R> target);
	
	void apply(T input, Consumer<R> output);
}
