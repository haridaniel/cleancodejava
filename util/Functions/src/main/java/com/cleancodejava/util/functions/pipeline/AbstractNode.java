package com.cleancodejava.util.functions.pipeline;

import com.cleancodejava.util.functions.function.Consumer;

abstract class AbstractNode<T, R> implements Node<T, R> {
	protected Consumer<R> output;

	@Override
	public void chain(Consumer<R> output) {
		this.output = output;
	}

}
