package hu.daniel.hari.learn.gwttest;

import hu.daniel.hari.learn.gwttest.servlet.AppServiceImpl;

import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.Log4JLogger;

import com.google.inject.name.Names;
import com.google.inject.servlet.ServletModule;

public class AppModule extends ServletModule {
	
	/** 
	 * "appmodule" --> TestModule.gwt.xml, 
	 * "appservice" --> AppService.java 
	 * **/
	static final String CONTEXT_PATH_APPMODULE_APPSERVICE = "/appmodule/appservice";
	
	@Override
	protected void configureServlets() {
		//BIND LOGGER
		bind(Log.class).to(Log4JLogger.class);
		
		//CONFIGURE SERVLETS
		serve(CONTEXT_PATH_APPMODULE_APPSERVICE).with(AppServiceImpl.class);
	}
	
}