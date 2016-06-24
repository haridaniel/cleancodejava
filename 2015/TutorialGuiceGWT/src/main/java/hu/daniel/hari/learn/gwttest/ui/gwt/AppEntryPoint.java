package hu.daniel.hari.learn.gwttest.ui.gwt;

import hu.daniel.hari.learn.gwttest.ui.gwt.pages.TestGuicePage1;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.user.client.ui.RootPanel;

public class AppEntryPoint implements EntryPoint {

	private RootPanel contentRigthPanel;

	public void onModuleLoad() {
		initPanels();
		addContentsToPanels();
	}

	private void initPanels() {
		contentRigthPanel = RootPanel.get("content-right");
	}

	private void addContentsToPanels() {
		contentRigthPanel.add(new TestGuicePage1());
	}

}
