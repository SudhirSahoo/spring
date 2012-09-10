package com.skumar.spring.core.bean.impl;

import com.skumar.spring.core.bean.Person2;

public class Person2Impl {//implements Person2{
	
	public String showMessage(String message) {
		System.out.println("Message: " + message);
		
		return "Coming from Person2";
	}
}
