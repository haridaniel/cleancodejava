package com.daniel.hari.util.asyncchain;

import com.daniel.hari.util.function.AsyncFunction;

interface Node<T, R> extends AsyncFunction<T, R> {
	void chain(AsyncFunction<T, R> target);
}
