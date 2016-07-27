package com.daniel.hari.util.pipeline;

import com.daniel.hari.util.function.Predicate;

class FilterNode<T> extends AbstractNode<T, T> {
	private Predicate<? super T> predicate;

	public FilterNode(Predicate<? super T> predicate) {
		this.predicate = predicate;
	}

	@Override
	public void accept(T t) {
		if (predicate.test(t))
			output.accept(t);
	}

}
