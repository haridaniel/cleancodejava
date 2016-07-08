package com.cleancodejava.util.functions.pipeline;

class EmptyNode<T> extends AbstractNode<T, T> {

	@Override
	public void accept(T t) {
		output.accept(t);
	}

}
