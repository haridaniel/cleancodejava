package hu.daniel.hari.learn.gwttest.controller.sessionscoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.inject.servlet.SessionScoped;

@SessionScoped
public class RequestCounter {
	private Log log = LogFactory.getLog(getClass());
	
	private int requestCount = 0;
	
	public RequestCounter() {
		log.debug("new");
	}
	
	public void increase() {
		log.debug("increase");
		requestCount++;
	}
	public int getRequestCountWithinSession() {
		log.debug("getRequestCountWithinSession=" + requestCount);
		return requestCount;
	}
	

}
