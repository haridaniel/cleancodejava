package com.cleancodejava.util.filtering;

import java.util.Timer;
import java.util.TimerTask;

import com.cleancodejava.util.filtering.BaseFloodFilterFunctionProxy.SimpleTimer;

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
		if(timerTask != null)
			timerTask.cancel();
		timerTask = new TimerTask() {
			@Override
			public void run() {
				runnable.run();
			}
		};
	}
	
}