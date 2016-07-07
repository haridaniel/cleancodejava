package com.cleancodejava.util.example.async;

import com.cleancodejava.util.function.AsyncFunction;
import com.cleancodejava.util.function.Consumer;

public class NumberService implements AsyncFunction<Integer, NumberService.NumberResult>{

	@Override
	public void apply(Integer input, Consumer<NumberResult> output) {
		output.accept(new NumberResult(input, -input));
	}
	
	
	public static class NumberResult {
		private Integer plus;
		private Integer minus;

		public NumberResult(Integer plus, Integer minus) {
			super();
			this.plus = plus;
			this.minus = minus;
		}

		@Override
		public String toString() {
			return "NumberResult [plus=" + plus + ", minus=" + minus + "]";
		}

	}

}
