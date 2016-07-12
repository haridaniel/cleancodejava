package com.cleancodejava.util.examples.functions.basic;

import com.cleancodejava.util.examples.functions.basic.async.LoggerProxy;
import com.cleancodejava.util.examples.functions.basic.async.TrimmerAsyncService;
import com.cleancodejava.util.examples.functions.basic.async.TrimmerService;
import com.cleancodejava.util.functions.asyncchain.AsyncChain;
import com.cleancodejava.util.functions.function.AsyncFunction;

public class MainAsyncTest {
	public static void main(String[] args) {new MainAsyncTest();}

	public MainAsyncTest() {
//		test1();
		test2();
	}

	private void test1() {
		AsyncFunction<String, String> asyncFunction = AsyncChain.ofTypes(String.class, String.class)
			.through(new LoggerProxy<>())
			.to(new TrimmerAsyncService())
			;

		asyncFunction.apply("  AA  ", this::print);
		asyncFunction.apply(" BB  ", this::print);
	}
	
	private void test2() {
		AsyncFunction<String, String> asyncFunction = AsyncChain.ofTypes(String.class, String.class)
				.through(new LoggerProxy<>())
				.to(new TrimmerService())
				;
		
		asyncFunction.apply("  AA  ", this::print);
		asyncFunction.apply(" BB  ", this::print);
	}
	
	private void print(String t) {
		System.out.println(t);
	}
}
