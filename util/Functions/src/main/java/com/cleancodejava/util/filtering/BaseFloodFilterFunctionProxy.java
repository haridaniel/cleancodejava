package com.cleancodejava.util.filtering;

import com.cleancodejava.util.functions.asyncchain.AbstractAsyncFunctionProxy;
import com.cleancodejava.util.functions.function.Consumer;
import com.cleancodejava.util.observable.Observable;
import com.cleancodejava.util.observable.Observable.ChangeListener;

/**
 * Timer is decoupled to be compatible with GWT.
 */
public class BaseFloodFilterFunctionProxy<T, R> extends AbstractAsyncFunctionProxy<T, R> {
	private int delayMS;
	private SimpleTimer timer;

	private T scheduledInput = null;
	private Consumer<R> lastFunctionCallback;
	private T lastForwardedInput = null;
	
	private Observable<State> observableState = new Observable<>(State.IDLE);

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
		setState(State.SCHEDULED);
		restartTimer();
	}
	
	/** cancels current scheduled value, even if it is already in-call state.
	 * if there is no value scheduled, then no effect. **/
	public synchronized void cancel() {
		timer.cancel();
		scheduledInput = null;
		lastForwardedInput = null;
		setState(State.IDLE);
	}

	private synchronized void onTimerFired() {
		T input = scheduledInput;
		scheduledInput = null;
		lastForwardedInput = input;
		setState(State.IN_CALL);
		getTarget().apply(input, new TargetCallback(input));
	}

	private synchronized void onTargetResult(T input, R result) {
		if(isLastForwardedInputAndNoScheduledInput(input)) {
			lastFunctionCallback.accept(result);
			setState(State.IDLE);
		}
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

	private void setState(State state) {
		observableState.set(state);
	}
	
	public void addStateChangeListener(ChangeListener<State> listener) {
		observableState.addChangeListener(listener);
	}

	public enum State {
		IDLE,
		SCHEDULED,
		IN_CALL
	}

	public interface SimpleTimer {
		void setRunnable(Runnable runnable);
		void reSchedule(int millis);
		void cancel();
	}

}

