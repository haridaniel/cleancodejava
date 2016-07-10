package com.cleancodejava.util.filtering;

import com.cleancodejava.util.functions.asyncchain.AbstractAsyncFunctionProxy;
import com.cleancodejava.util.functions.function.Consumer;

/**
 * Timer is decoupled to be compatible with GWT.
 */
public class BaseFloodFilterFunctionProxy<T, R> extends AbstractAsyncFunctionProxy<T, R> {
	private int delayMS;
	private SimpleTimer timer;

	private T scheduledInput = null;
	private Consumer<R> lastFunctionCallback;
	private T lastForwardedInput = null;

	public BaseFloodFilterFunctionProxy(SimpleTimer timer, int delayMS) {
		this.timer = timer;
		this.delayMS = delayMS;
		initTimer();
	}

	private void initTimer() {
		timer.setRunnable(new Runnable() {
			@Override
			public void run() {
				onTimerFired();
			}
		});
	}
	
	@Override
	public synchronized void apply(T input, Consumer<R> callback) {
		scheduledInput = input;
		lastFunctionCallback = callback; 
		restartTimer();
	}

	private synchronized void onTimerFired() {
		T input = scheduledInput;
		scheduledInput = null;
		lastForwardedInput = input;
		getTarget().apply(input, new TargetCallback(input));
	}

	private synchronized void onTargetResult(T input, R result) {
		if(isLastForwardedInputAndNoScheduledInput(input))
			lastFunctionCallback.accept(result);
	}
	
	private boolean isLastForwardedInputAndNoScheduledInput(T input) {
		return scheduledInput == null && lastForwardedInput == input;
	}

	
	private void restartTimer() {
		timer.reSchedule(delayMS);
	}
	
	private class TargetCallback implements Consumer<R> {
		private T input;

		public TargetCallback(T input) {
			this.input = input;
		}
		
		@Override
		public void accept(R result) {
			onTargetResult(input, result);
		}
	}
	
	public void setDelayMs(int delayMS) {
		this.delayMS = delayMS;
	}
	
	public interface SimpleTimer {
		void setRunnable(Runnable runnable);
		void reSchedule(int millis);
	}

}

