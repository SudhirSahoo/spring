package com.skumar.spring.core.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.skumar.spring.core.bean.CustomerAnnotation;

public class MainAppAnnotation {
	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-expression-language-annotation.xml");
		CustomerAnnotation obj = (CustomerAnnotation) context
				.getBean("customerBean");
		
		System.out.println(obj);
		
		System.out.println("showLogicalOperators" + obj.showLogicalOperators());
		
		System.out.println("showTernaryOperators : " + obj.showTernaryOperators());
		
		
		// List and Map
		System.out.println("List Value: " + obj.getList());
		System.out.println("Map Value: " + obj.getMap());

		// Regular Expression
		System.out.println("Valid email: " + obj.isValidEmail());
		System.out.println("Valid Digit: " + obj.isValidDigit());
	}
}
