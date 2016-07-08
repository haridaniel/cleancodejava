package com.cleancodejava.util.example;

import com.cleancodejava.util.asyncchain.AsyncChain;
import com.cleancodejava.util.example.async.LoggerProxy;
import com.cleancodejava.util.example.async.TrimmerService;
import com.cleancodejava.util.function.AsyncFunction;
import com.cleancodejava.util.function.Consumer;

public class MainAsyncTest {
	public static void main(String[] args) {new MainAsyncTest();}

	public MainAsyncTest() {
		
		AsyncFunction<String, String> asyncFunction = AsyncChain.ofTypes(String.class, String.class)
			.through(new LoggerProxy<>())
			.to(new TrimmerService())
			;

		Consumer<String> output = new Consumer<String>() {
				@Override
				public void accept(String t) {
					System.out.println(t);
				}
			};
		
		asyncFunction.apply(" AA  ", output);
		asyncFunction.apply(" BB  ", output);
		
	}
	
}
