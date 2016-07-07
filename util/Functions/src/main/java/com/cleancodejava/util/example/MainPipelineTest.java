package com.cleancodejava.util.example;

import java.util.Arrays;
import java.util.List;

import com.cleancodejava.util.example.pipe.DuplicateSkipper;
import com.cleancodejava.util.function.Consumer;
import com.cleancodejava.util.pipeline.Pipeline;

public class MainPipelineTest {
	public static void main(String[] args) {new MainPipelineTest();}
	
	private List<String> STRINGS = Arrays.asList(new String[] {
			"  Peter  ",
			"Ida",
			"Po",
			"Kovacs Lajos",
			"BO",
			"  Tamara    ",
			"    Tamara",
			"Tamara",
			"Adam",
	}); 

	
	public MainPipelineTest() {
		
		Consumer<String> consumer = Pipeline.ofInputType(String.class)
				.filter(s -> !"Po".equals(s))
//				.peek(s -> System.out.println("peek: " + s))
				.map(s -> s.trim())
				.filter(new DuplicateSkipper<>())
//				.map(s -> s + "!")
//				.map(s -> s.length())
				.to(s -> System.out.println(s))
				;
		

		STRINGS.stream()
			.forEach(consumer::accept);
		
		
	}
}
