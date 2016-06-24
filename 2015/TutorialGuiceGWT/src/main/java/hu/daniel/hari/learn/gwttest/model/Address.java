package hu.daniel.hari.learn.gwttest.model;

import java.io.Serializable;

/** DATA STRUCTURE **/
public class Address implements Serializable {
	
	public String addressString;
		
	public Address() {
		//Needed for GWT RPC
	}
	public Address(String addressString) {
		this.addressString = addressString;
	}
	@Override
	public String toString() {
		return "Address [addressString=" + addressString + "]";
	}
}
