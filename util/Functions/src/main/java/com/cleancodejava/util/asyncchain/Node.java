package com.cleancodejava.util.asyncchain;

import com.cleancodejava.util.function.AsyncFunction;

interface Node<T, R> extends AsyncFunction<T, R> {
	void chain(AsyncFunction<T, R> target);
}
