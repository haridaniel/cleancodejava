package com.cleancodejava.util.functions.pipeline;

import com.cleancodejava.util.functions.function.Function;

class MapperNode<T, R> extends AbstractNode<T, R> {
	private Function<? super T, ? extends R> mapper;

	public MapperNode(Function<? super T, ? extends R> mapper) {
		this.mapper = mapper;
	}

	@Override
	public void accept(T t) {
		output.accept(mapper.apply(t));
	}

}
