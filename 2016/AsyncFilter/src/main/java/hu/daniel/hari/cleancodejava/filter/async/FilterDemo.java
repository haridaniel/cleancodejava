package hu.daniel.hari.cleancodejava.filter.async;

import java.util.Arrays;
import java.util.List;

import hu.daniel.hari.cleancodejava.filter.async.impls.AsyncDelayFilter;
import hu.daniel.hari.cleancodejava.filter.async.impls.DelayFilter;
import hu.daniel.hari.cleancodejava.filter.async.impls.DuplicateRemoverFilter;
import hu.daniel.hari.cleancodejava.filter.async.impls.MinLengthFilter;
import hu.daniel.hari.cleancodejava.filter.async.impls.TrimFilter;
import hu.daniel.hari.cleancodejava.filter.async.impls.UppercaseFilter;

public class FilterDemo {
	
	private static List<String> STRINGS = Arrays.asList(new String[] {
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
	
	public static void main(String[] args) {
		System.out.println("inputs: " + STRINGS);
		
		
		FilterChain<String> filterChain = new FilterChain<>(System.out::println, 
				new TrimFilter(),
				new DuplicateRemoverFilter<String>(), 
				new MinLengthFilter(3), 
				new UppercaseFilter(),
				new AsyncDelayFilter<String>(500)
		);

		STRINGS.stream()
			.forEach(s -> filterChain.filter(s));
	}
	
}

