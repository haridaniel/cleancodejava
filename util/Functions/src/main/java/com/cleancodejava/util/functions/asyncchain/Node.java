package com.cleancodejava.util.functions.asyncchain;

import com.cleancodejava.util.functions.function.AsyncFunction;

interface Node<T, R> extends AsyncFunction<T, R> {
	void chain(AsyncFunction<T, R> target);
}
