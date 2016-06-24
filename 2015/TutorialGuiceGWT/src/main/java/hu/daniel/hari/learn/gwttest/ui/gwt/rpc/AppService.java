package hu.daniel.hari.learn.gwttest.ui.gwt.rpc;

import hu.daniel.hari.learn.gwttest.model.Address;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("appservice")
public interface AppService extends RemoteService {
	List<Address> getAddressList();
	void addAddress(Address address);
	void exportAddressList();
	void increaseRequestCountWithinSession();
	int getRequestCountWithinSession();
}
