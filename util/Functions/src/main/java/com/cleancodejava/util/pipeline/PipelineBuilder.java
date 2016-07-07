package com.cleancodejava.util.pipeline;

import com.cleancodejava.util.function.AsyncFunction;
import com.cleancodejava.util.function.Consumer;
import com.cleancodejava.util.function.Function;
import com.cleancodejava.util.function.Predicate;

/**
 * Use {@link Pipeline} for building.
 *
 * @param <T>	- output type (of current phase)
 * @param <T0> 	- input type (of the full chain)
 */
public class PipelineBuilder<T, T0> {
	private Consumer<T0> pipelineChainInput;
	private Node<?, T> node;
	
	private PipelineBuilder(Node<?, T> node, Consumer<T0> pipelineChainInput) {
		this.node = node;
		this.pipelineChainInput = pipelineChainInput;
	}

	public PipelineBuilder<T, T0> filter(Predicate<? super T> predicate) {
		return chainedBuilder(new FilterNode<T>(predicate));
	}

	public PipelineBuilder<T, T0> peek(Consumer<? super T> action) {
		return chainedBuilder(new PeekNode<T>(action));
	}

	public <R> PipelineBuilder<R, T0> map(Function<? super T, ? extends R> mapper) {
		return chainedBuilder(new MapperNode<T, R>(mapper));
	}

	public <R> PipelineBuilder<R, T0> through(final AsyncFunction<? super T, R> asyncFunction) {
		return chainedBuilder(new AsyncFunctionNode<T, R>(asyncFunction));
	}

	private <R> PipelineBuilder<R, T0> chainedBuilder(Node<T, R> chainedNode) {
		node.chain(chainedNode);
		return new PipelineBuilder<R, T0>(chainedNode, pipelineChainInput);
	}

	/**
	 * Terminates the pipeline with the given output.
	 *  
	 * @param output the output of the pipeline.
	 * @return the input of the pipeline.
	 */
	public Consumer<T0> to(Consumer<T> output) {
		node.chain(output);
		return pipelineChainInput;
	}
	
	/**
	 * Terminates the pipeline without output.
	 *  
	 * @return the input of the pipeline.
	 */
	public Consumer<T0> toNothing() {
		return to(new NullConsumer<T>());
	}
	
	static <T> PipelineBuilder<T, T> create() {
		//Start the pipeline with an empty node 
		EmptyNode<T> emptyNode = new EmptyNode<T>();
		return new PipelineBuilder<T, T>(emptyNode, emptyNode);
	}
	
}
