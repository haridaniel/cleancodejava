package com.cleancodejava.util.functions.function;

/**
 * @param <T> input type
 * @param <R> result type
 */
public interface AsyncFunction<T, R> {

	void apply(T input, Consumer<R> output);
	
}
