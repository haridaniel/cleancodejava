package com.daniel.hari.util.gwtincompatible.filtering;

import java.util.Timer;
import java.util.TimerTask;

import com.daniel.hari.util.filtering.BaseFloodFilterFunctionProxy.SimpleTimer;

class JavaTimer implements SimpleTimer {
	private Timer timer = new Timer(false);
	private TimerTask timerTask;
	private Runnable runnable;
	
	@Override
	public void setRunnable(Runnable runnable) {
		this.runnable = runnable;
	}

	@Override
	public void reSchedule(int millis) {
		reCreateTimerTask();
		timer.schedule(timerTask, millis);
	}

	private void reCreateTimerTask() {
		cancelTimer();
		timerTask = new TimerTask() {
			@Override
			public void run() {
				runnable.run();
			}
		};
	}

	private void cancelTimer() {
		if(timerTask != null)
			timerTask.cancel();
	}

	@Override
	public void cancel() {
		cancelTimer();
	}
	
}