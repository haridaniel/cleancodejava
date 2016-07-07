package com.cleancodejava.util.example.pipe;

import java.util.Objects;

import com.cleancodejava.util.function.Predicate;

/**
 * (stateful) 
 */
public class DuplicateSkipper<T> implements Predicate<T> {
	private T lastInput = null;
	
	@Override
	public boolean test(T input) {
		boolean duplicated = Objects.equals(input, lastInput);
		if(!duplicated) {
			lastInput = input;
			return true;
		} else
			return false;
	}

}
