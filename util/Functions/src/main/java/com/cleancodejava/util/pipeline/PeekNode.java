package com.cleancodejava.util.pipeline;

import com.cleancodejava.util.function.Consumer;

class PeekNode<T> extends AbstractNode<T, T> {
	private Consumer<? super T> action;

	public PeekNode(Consumer<? super T> action) {
		this.action = action;
	}

	@Override
	public void accept(T t) {
		action.accept(t);
		output.accept(t);
	}

}
