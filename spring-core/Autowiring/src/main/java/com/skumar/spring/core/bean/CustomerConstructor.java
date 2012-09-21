package com.skumar.spring.core.bean;

public class CustomerConstructor {
	
	private Address address;

	public CustomerConstructor(Address address) {
		this.address = address;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
