package com.daniel.hari.util.pipeline;

class EmptyNode<T> extends AbstractNode<T, T> {

	@Override
	public void accept(T t) {
		output.accept(t);
	}

}
