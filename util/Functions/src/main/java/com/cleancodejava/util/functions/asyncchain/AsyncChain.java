package com.cleancodejava.util.functions.asyncchain;

import com.cleancodejava.util.functions.function.AsyncFunction;

/**
 * Fluent interface to build a chain of async function proxies that ends in an async function.
 * 
 * @see {@link AsyncFunction}
 * @see {@link AsyncFunctionProxy}
 * 
 * @author Daniel Hari
 */
public class AsyncChain {
	private AsyncChain() {}
	
	public static <T, R> ChainBuilder<T, R> ofTypes(Class<T> inputType, Class<R> resultType) {
		return of();
	}
	public static <T, R> ChainBuilder<T, R> of() {
		return new ChainBuilder<>();
	}
	
}
