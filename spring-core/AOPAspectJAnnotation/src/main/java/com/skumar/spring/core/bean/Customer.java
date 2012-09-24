package com.skumar.spring.core.bean;

public class Customer {
	private String name;
	private String url;

	public void setName(String name) {
		this.name = name;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void printName() {
		System.out.println("Customer name : " + this.name);
	}

	public void printURL() {
		System.out.println("Customer website : " + this.url);
	}
	
	public int addInteger() {
		int i = 5 + 5;
		System.out.println("Add value : " + i);
		return i;
	}
	
	public void addCustomerAround(String name){
		System.out.println("addCustomerAround() is running, args : " + name);
	}
	
	public void throwException() {//throws Exception{
		String str = null;
		str.toString();
	}
	public void printThrowException() {
		throw new IllegalArgumentException();
	}
}
