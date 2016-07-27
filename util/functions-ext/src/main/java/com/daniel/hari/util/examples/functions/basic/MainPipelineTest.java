package com.daniel.hari.util.examples.functions.basic;

import java.util.Arrays;
import java.util.List;

import com.daniel.hari.util.examples.functions.basic.pipe.DuplicateSkipper;
import com.daniel.hari.util.function.Consumer;
import com.daniel.hari.util.pipeline.Pipeline;

public class MainPipelineTest {
	public static void main(String[] args) {new MainPipelineTest();}
	
	private List<String> STRINGS = Arrays.asList(new String[] {
			"  Peter  ",
			"Ida",
			"Po",
			"Kovacs Lajos",
			"BO",
			"  Tamara    ",
			"    TAMARA",
			"Tamara",
			"Adam",
	}); 

	
	public MainPipelineTest() {
		Consumer<String> pipeline = Pipeline.ofInputType(String.class)
				.map(s -> s.trim())
				.map(s -> s.toLowerCase())
				.filter(new DuplicateSkipper<>())
				.to(s -> System.out.println(s))
				;
		
		STRINGS.stream()
			.forEach(pipeline::accept);
	}

}
