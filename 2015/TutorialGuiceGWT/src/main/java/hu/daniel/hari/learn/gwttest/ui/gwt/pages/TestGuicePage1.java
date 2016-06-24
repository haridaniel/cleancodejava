package hu.daniel.hari.learn.gwttest.ui.gwt.pages;

import hu.daniel.hari.learn.gwttest.model.Address;
import hu.daniel.hari.learn.gwttest.ui.gwt.rpc.AppService;
import hu.daniel.hari.learn.gwttest.ui.gwt.rpc.AppServiceAsync;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class TestGuicePage1 extends Composite {
	interface TestContentPageUiBinder extends UiBinder<Widget, TestGuicePage1> {}
	private static TestContentPageUiBinder uiBinder = GWT.create(TestContentPageUiBinder.class);
	
	/** GWT SERVICE **/
	private static AppServiceAsync service = GWT.create(AppService.class);
	
	@UiField Label lbRequestCountWithinHttpSession;
	@UiField TextBox tbNewAddress;
	@UiField Button btNewAddress;
	@UiField VerticalPanel addressListPanel;
	@UiField Button btExportAddressList;

	public TestGuicePage1() {
		initWidget(uiBinder.createAndBindUi(this));
		
		//ASYNC CALLS
		increaseAndUpdateRequestCount();
		//ASYNC CALL
		updateAddressListPanel();
	}

	private void increaseAndUpdateRequestCount() {
		service.increaseRequestCountWithinSession(new AsyncCallback<Void>() {
			@Override
			public void onSuccess(Void result) {
				//HAPPY. NOW UPDATE IT
				updateRequestCount();
			}
			@Override
			public void onFailure(Throwable caught) {
				System.err.println("onFailure");
			}
		});
	}

	private void updateRequestCount() {
		service.getRequestCountWithinSession(new AsyncCallback<Integer>() {
			@Override
			public void onSuccess(Integer requestCountWithinSession) {
				//UPDATE LABEL
				lbRequestCountWithinHttpSession.setText(requestCountWithinSession.toString());
			}
			@Override
			public void onFailure(Throwable caught) {
				System.err.println("onFailure");
			}
		});
	}

	/** call to server for addressList **/
	private void updateAddressListPanel() {
		service.getAddressList(new AsyncCallback<List<Address>>() {
			@Override
			public void onSuccess(List<Address> addresses) {
				updateAddressListPanel(addresses);
			}
			@Override
			public void onFailure(Throwable caught) {
				System.err.println("onFailure");
			}
		});
	}

	private void updateAddressListPanel(List<Address> addresses) {
		//CLEAR THE PANEL
		addressListPanel.clear();
		//FILL THE PANEL
		for (Address address : addresses) {
			String addressString = address.addressString;
			addressListPanel.add(new Label(addressString ));
		}
	}

	@UiHandler("btNewAddress")
	void onBtNewAddressClick(ClickEvent event) {
		actionNewAddressThenUpdateList();
	}

	private void actionNewAddressThenUpdateList() {
		//BUILD ADDRESS
		String addressString = tbNewAddress.getValue();
		Address address = new Address(addressString);
		//CALL SERVICE
		service.addAddress(address , new AsyncCallback<Void>() {
			@Override
			public void onSuccess(Void result) {
				//INSERT CALL SUCCEED, LETS UPDATE LIST
				updateAddressListPanel();
				//CLEAR THE FIELD
				tbNewAddress.setValue(null);
			}
			@Override
			public void onFailure(Throwable caught) {
				System.err.println("onFailure");
			}
		});
	}
	@UiHandler("btExportAddressList")
	void onBtExportAddressListClick(ClickEvent event) {
		actionExportAddressList();
	}

	private void actionExportAddressList() {
		service.exportAddressList(new AsyncCallback<Void>() {
			@Override
			public void onSuccess(Void result) {
				//HAPPY
			}
			@Override
			public void onFailure(Throwable caught) {
				System.err.println("onFailure");
			}
		});
	}
}
