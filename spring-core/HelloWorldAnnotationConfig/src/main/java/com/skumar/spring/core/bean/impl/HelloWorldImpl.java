package com.skumar.spring.core.bean.impl;

import com.skumar.spring.core.bean.HelloWorld;

public class HelloWorldImpl implements HelloWorld {
	 
	public void printHelloWorld(String msg) {
 
		System.out.println("Hello : " + msg);
	}
 
}
