package com.skumar.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"Spring-HelloWorld.xml");

		HelloWorld obj = (HelloWorld) context.getBean("helloWorldBean");
		obj.printHello();
	}

}
