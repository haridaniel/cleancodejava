package hu.daniel.hari.learn.gwttest.servlet;

import hu.daniel.hari.learn.gwttest.controller.requestscoped.ContentExporter;
import hu.daniel.hari.learn.gwttest.controller.sessionscoped.RequestCounter;
import hu.daniel.hari.learn.gwttest.controller.singleton.AddressManager;
import hu.daniel.hari.learn.gwttest.model.Address;
import hu.daniel.hari.learn.gwttest.ui.gwt.rpc.AppService;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

@Singleton
public class AppServiceImpl extends RemoteServiceServlet implements AppService {
	private Log log = LogFactory.getLog(getClass());
	
	@Inject
	/** SINGLETON **/
	private AddressManager addressManager;

	@Inject
	/** SESSION SCOPED **/
	private Provider<RequestCounter> requestCounterProvider;
	
	@Inject
	/** REQUEST SCOPED **/
	private Provider<ContentExporter> contentExporterProvider;
	
	@Inject
	public AppServiceImpl() {
		log.info("new");
	}
	
	@Override
	public List<Address> getAddressList() {
		return addressManager.getAddressList();
	}

	@Override
	public void addAddress(Address address) {
		addressManager.addAddress(address);
	}

	@Override
	public void exportAddressList() {
		contentExporterProvider.get().exportAddressList();
	}

	@Override
	public void increaseRequestCountWithinSession() {
		requestCounterProvider.get().increase();
	}

	@Override
	public int getRequestCountWithinSession() {
		return requestCounterProvider.get().getRequestCountWithinSession();
	}

}
