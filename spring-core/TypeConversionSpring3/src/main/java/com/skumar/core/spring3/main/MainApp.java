package com.skumar.core.spring3.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.skumar.core.spring3.bean.CustomerSSN;

public class MainApp {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring3-type-conversion.xml");

		CustomerSSN obj = (CustomerSSN) context.getBean("customerSSN");
		System.out.println("Area: " + obj.getArea());
	}

}
