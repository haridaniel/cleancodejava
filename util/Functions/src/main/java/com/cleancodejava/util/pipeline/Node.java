package com.cleancodejava.util.pipeline;

import com.cleancodejava.util.function.Consumer;

/**
 * A {@link Consumer} that can be chained to another {@link Consumer}.
 * 
 * @param <T> input type
 * @param <R> output type
 */
interface Node<T, R> extends Consumer<T> {
	void chain(Consumer<R> output);
}
