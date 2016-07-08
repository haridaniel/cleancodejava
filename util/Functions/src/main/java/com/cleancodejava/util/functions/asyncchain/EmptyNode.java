package com.cleancodejava.util.functions.asyncchain;

import com.cleancodejava.util.functions.function.AsyncFunction;
import com.cleancodejava.util.functions.function.Consumer;

class EmptyNode<T, R> implements Node<T, R>{
	private AsyncFunction<T, R> target;

	@Override
	public void apply(T input, Consumer<R> output) {
		target.apply(input, output);
	}

	@Override
	public void chain(AsyncFunction<T, R> target) {
		this.target = target;
	}

}
