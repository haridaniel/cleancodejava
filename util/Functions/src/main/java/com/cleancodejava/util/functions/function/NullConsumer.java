package com.cleancodejava.util.functions.function;


/** Do nothing. **/
public class NullConsumer<T> implements Consumer<T> {
	@Override
	public void accept(T t) {}
}
