package com.skumar.spring.core.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("addressBean")
public class AddressAnnotation {
	
	@Value("Thane, Mumbai")
	private String street;
 
	@Value("400607")
	private int postcode;
 
	@Value("IN")
	private String country;
	
	private Map<String, String> map;
	private List<String> list;
	
	@Value("nospam@abc.com")
	String emailAddress;
	
	public AddressAnnotation() {
		map = new HashMap<String, String>();
		map.put("MapA", "This is A");
		map.put("MapB", "This is B");
		map.put("MapC", "This is C");
 
		list = new ArrayList<String>();
		list.add("List0");
		list.add("List1");
		list.add("List2");
 
	}
 
	public String getFullAddress(String prefix) {
 
		return prefix + " : " + street + " " + postcode + " " + country;
	}
 
	
 
	public String getStreet() {
		return street;
	}



	public void setStreet(String street) {
		this.street = street;
	}



	public int getPostcode() {
		return postcode;
	}



	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}
	
	public Map<String, String> getMap() {
		return map;
	}
 
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
 
	public List<String> getList() {
		return list;
	}
 
	public void setList(List<String> list) {
		this.list = list;
	}
	
 
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", postcode=" + postcode
				+ ", country=" + country + "]";
	}
}
