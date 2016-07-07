package com.cleancodejava.util.example;

import java.util.Arrays;
import java.util.List;

import com.cleancodejava.util.asyncchain.AsyncChain;
import com.cleancodejava.util.example.async.CharCounterService;
import com.cleancodejava.util.example.async.LoggerProxy;
import com.cleancodejava.util.example.async.NumberService;
import com.cleancodejava.util.example.async.UppercaseService;
import com.cleancodejava.util.example.pipe.DuplicateSkipper;
import com.cleancodejava.util.function.AsyncFunction;
import com.cleancodejava.util.function.Consumer;
import com.cleancodejava.util.pipeline.Pipeline;


public class MainPipelineAsyncTest {
	public static void main(String[] args) {new MainPipelineAsyncTest();}

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

	public MainPipelineAsyncTest() {
		
//		test1();
		test2();
//		test3();
//		test4();
		
	}

	private void test1() {
		Consumer<String> consumer = Pipeline.ofInputType(String.class)
			.filter(s -> !"Po".equals(s))
			.map(s -> s.trim())
			.filter(new DuplicateSkipper<>())
			.map(s -> s + "!")
			.through(new UppercaseService())
			.map(s -> s + "#a#")
			.through(new UppercaseService())
			.to(s -> System.out.println(s))
			;
		
		STRINGS.stream()
			.forEach(consumer::accept);
	}

	private void test2() {
	
		Consumer<String> pipeInput = Pipeline.ofInputType(String.class)
			.map(s -> s.trim())
			.filter(new DuplicateSkipper<>())
			.through(AsyncChain.ofTypes(String.class, String.class)
				.through(new LoggerProxy<>())
				.to(new UppercaseService())
			)
			.toNothing()
			;
		
		STRINGS.stream()
			.forEach(pipeInput::accept);
		
	}

	private void test3() {
		Consumer<String> pipeInput = Pipeline.ofInputType(String.class)
				.filter(s -> !"Po".equals(s))
				.map(s -> s.trim())
				.filter(new DuplicateSkipper<>())
				.through(new CharCounterService())
				.filter(i -> i > 4)
				.map(i -> - i)
				.to(System.out::println)
				;
		
		STRINGS.stream()
			.forEach(pipeInput::accept);
	}

	private void test4() {
		Consumer<String> pipeInput = Pipeline.ofInputType(String.class)
			.filter(s -> !"Po".equals(s))
			.map(s -> s.trim())
			.filter(new DuplicateSkipper<>())
			.through(new CharCounterService())
			.map(i -> -i)
			.through(new NumberService())
			.to(System.out::println)
			;
			
		
		STRINGS.stream()
			.forEach(pipeInput::accept);
		
		
	}

}
