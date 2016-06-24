package hu.daniel.hari.learn.gwttest.controller.singleton;

import hu.daniel.hari.learn.gwttest.model.Address;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

@Singleton
public class AddressManager {
	private static final String DEFAULT_ADDRESSES_STRING = 
			"2600 Vác, Damjanich u.1;8600 Szeged, Diófa u. 39;3300 Eger, Faiskola út 15.;3000 Hatvan, Horváth Mihály út 18.";
	private static final List<String> DEFAULT_ADDRESSES = Arrays.asList(DEFAULT_ADDRESSES_STRING.split(";"));
	
	private Log log = LogFactory.getLog(getClass());
	
	private List<Address> addressList = new ArrayList<>();

	@Inject
	public AddressManager(
			) {
		log.debug("new");
		insertDefaultAddresses(DEFAULT_ADDRESSES);
	}

	private void insertDefaultAddresses(List<String> defaultAddresses) {
		for (String defaultAddress : defaultAddresses) {
			addressList.add(new Address(defaultAddress));
		}
	}
	
	public List<Address> getAddressList() {
		log.debug("getAddressList");
		return new ArrayList<>(addressList);
	}

	public void addAddress(Address address) {
		log.debug("addAddress " + address);
		addressList.add(address);
	}
	
}
