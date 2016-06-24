package hu.daniel.hari.learn.gwttest.controller.requestscoped;

import hu.daniel.hari.learn.gwttest.controller.singleton.AddressManager;
import hu.daniel.hari.learn.gwttest.model.Address;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.google.inject.servlet.RequestScoped;

@RequestScoped
public class ContentExporter {
	private Log log = LogFactory.getLog(getClass());
	
	private final AddressManager addressManager;

	@Inject
	public ContentExporter(
			AddressManager addressManager
			) {
		log.debug("new");
		this.addressManager = addressManager;
	}
	
	public void exportAddressList() {
		log.debug("exportAddressList");

		List<Address> addressList = addressManager.getAddressList();
		for (Address address : addressList) {
			log.info(address.addressString);
		}
	}

}
