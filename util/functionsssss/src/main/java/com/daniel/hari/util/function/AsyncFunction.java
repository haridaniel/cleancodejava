package com.daniel.hari.util.function;

/**
 * @param <T> input type
 * @param <R> result type
 */
public interface AsyncFunction<T, R> {

	void apply(T input, Consumer<R> output);
	
}
