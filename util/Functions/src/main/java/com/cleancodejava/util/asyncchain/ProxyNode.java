package com.cleancodejava.util.asyncchain;

import com.cleancodejava.util.function.AsyncFunction;
import com.cleancodejava.util.function.Consumer;

class ProxyNode<T, R> implements Node<T, R> {
	private AsyncFunctionProxy<T, R> proxy;

	public ProxyNode(AsyncFunctionProxy<T, R> proxy) {
		this.proxy = proxy;
	}

	@Override
	public void apply(T input, Consumer<R> output) {
		proxy.apply(input, output);
	}

	@Override
	public void chain(AsyncFunction<T, R> target) {
		proxy.setTarget(target);
	}

}
