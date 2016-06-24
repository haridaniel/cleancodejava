package hu.daniel.hari.learn.gwttest.ui.gwt.rpc;

import hu.daniel.hari.learn.gwttest.model.Address;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface AppServiceAsync {
	void getAddressList(AsyncCallback<List<Address>> callback);
	void addAddress(Address address, AsyncCallback<Void> callback);
	void exportAddressList(AsyncCallback<Void> callback);
	void increaseRequestCountWithinSession(AsyncCallback<Void> callback);
	void getRequestCountWithinSession(AsyncCallback<Integer> callback);
}
