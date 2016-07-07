package com.cleancodejava.util.asyncchain;

import com.cleancodejava.util.function.AsyncFunction;
import com.cleancodejava.util.function.Consumer;

public class ChainBuilder<T, R> {

	private final Node<T, R> firstNode;
	private Node<T, R> lastNode;

	public ChainBuilder() {
		firstNode = new EmptyNode<>();
		lastNode = firstNode;
	}

	public ChainBuilder<T, R> through(AsyncFunctionProxy<T, R> proxy) {
		ProxyNode<T, R> proxyNode = new ProxyNode<>(proxy);
		chain(proxyNode);
		return this;
	}

	private void chain(Node<T, R> node) {
		lastNode.chain(node);
		lastNode = node;
	}

	public AsyncFunction<T, R> to(AsyncFunction<T, R> asyncFunction) {
		lastNode.chain(asyncFunction);
		return new FinalBuilder<>(firstNode).build();
	}

	public static class FinalBuilder<T, R> {

		private AsyncFunction<T, R> asyncFunction;

		public FinalBuilder(AsyncFunction<T, R> asyncFunction) {
			this.asyncFunction = asyncFunction;
		}

		public AsyncFunction<T, R> build() {
			return new AsyncFunction<T, R>() {
				@Override
				public void apply(T input, Consumer<R> output) {
					asyncFunction.apply(input, output);
				}
			};
		}
	}

}
