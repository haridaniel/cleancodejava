package com.cleancodejava.util.pipeline;

import com.cleancodejava.util.function.Consumer;

/** Do nothing. **/
class NullConsumer<T> implements Consumer<T> {
	@Override
	public void accept(T t) {}
}
