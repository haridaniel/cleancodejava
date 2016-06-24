package hu.daniel.hari.learn.gwttest.boot;

import hu.daniel.hari.learn.gwttest.AppModule;

import javax.servlet.ServletContextEvent;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

public class AppGuiceServletContextListener extends GuiceServletContextListener {

	@Override
	protected Injector getInjector() {
		return Guice.createInjector(
				new AppModule()
				);
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
	}
	
}
