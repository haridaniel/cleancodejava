package com.cleancodejava.util.pipeline;

/** 
 * Fluent interface to build a serial chain of operations like filtering, transforming, mapping. 
 * @author Dani
 */
public class Pipeline {
	private Pipeline() {}
	
    /**
     * <p>Returns a pipeline builder with the given input type.
     * <p>Pipelines can be construct of sequential operations like filtering, transforming.
     */
	public static <T> PipelineBuilder<T, T> ofInputType(Class<T> inputType) {
		return of();
	}
	
	/**
	 * <p>Returns a pipeline builder (input type inferred).  
	 * <p>Pipelines can be construct of sequential operations like filtering, transforming.
	 */
	public static <T> PipelineBuilder<T, T> of() {
		return PipelineBuilder.create();
	}

}
