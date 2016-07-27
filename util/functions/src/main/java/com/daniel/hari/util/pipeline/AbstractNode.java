package com.daniel.hari.util.pipeline;

import com.daniel.hari.util.function.Consumer;

abstract class AbstractNode<T, R> implements Node<T, R> {
	protected Consumer<R> output;

	@Override
	public void chain(Consumer<R> output) {
		this.output = output;
	}

}
