package com.daniel.hari.util.examples.filtering.floodfilter;

import com.daniel.hari.util.asyncchain.AsyncChain;
import com.daniel.hari.util.function.AsyncFunction;
import com.daniel.hari.util.function.NullConsumer;
import com.daniel.hari.util.gwtincompatible.filtering.FloodFilteringAsyncFunctionProxy;

public class Main {
	public static void main(String[] args) {
		new Main();
	}
	
	private AsyncFunction<String, String> asyncFunction;
	
	public Main() {
		System.out.println("Example of floodfilter");
		
		asyncFunction = AsyncChain.ofTypes(String.class, String.class)
			.through(new LoggerAsyncFunctionProxy<>())
			.through(new FloodFilteringAsyncFunctionProxy<>(500))
			.to(new UppercaseAsyncFunction(250))
			;
		
		test1();
		
//		test2(500);
//		test2(749);
	}

	private void test1() {
		applyAndSleep("a", 100);
		applyAndSleep("ab", 200);
		applyAndSleep("abc", 400);
		applyAndSleep("abcd", 550);
		applyAndSleep("abcde", 700);
		applyAndSleep("abcdef", 800);
		applyAndSleep("abcdefg", 900);
		applyAndSleep("abcdefgh", 1000);
		applyAndSleep("abcdefghi", 1100);
	}

	private void test2(int millis) {
		applyAndSleep("a", millis);
		applyAndSleep("ab", millis);
		applyAndSleep("abc", millis);
		applyAndSleep("abcd", millis);
		applyAndSleep("abcde", millis);
		applyAndSleep("abcdef", millis);
		applyAndSleep("abcdefg", millis);
		applyAndSleep("abcdefgh", millis);
	}

	private  void applyAndSleep(String input, int millis) {
		asyncFunction.apply(input, new NullConsumer<>());
		sleep(millis);
	}
	
	private void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}	
}
