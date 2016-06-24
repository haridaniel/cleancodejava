package hu.daniel.hari.learn.spring.aop.profiling.service;

import org.springframework.stereotype.Component;

/**
 * Example service class that we want to profile through AOP.
 * (Notice that no need to insert any line of profiling code!)
 * 
 * @author Daniel Hari
 */
@Component
public class FooService {

	public void doShortJob() {
		sleep(10l);
	}

	public void doLongJob() {
		sleep(300l);
	}

	public void doSomethingThatThrowsException() {
		throw new RuntimeException("Simulated Exception.");
	}

	private void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
