package com.cleancodejava.util.asyncchain;

import com.cleancodejava.util.function.AsyncFunction;
import com.cleancodejava.util.function.Consumer;

public interface AsyncFunctionProxy<T, R> {
	void apply(T input, Consumer<R> output, AsyncFunction<T, R> target);
}
