package com.skumar.spring.core;

public class HelloWorld {
	private String message;
	 
	public void setMessage(String message) {
		this.message = message;
	}
 
	public void printHello() {
		System.out.println("Hello ! " + message);
	}
}
