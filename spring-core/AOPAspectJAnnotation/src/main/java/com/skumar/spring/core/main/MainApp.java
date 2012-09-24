package com.skumar.spring.core.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.skumar.spring.core.bean.Customer;

/*
 NOTE: In this example, all the methods in a customer service class are intercepted (advice) automatically. 
 But for most cases, you may need to use Pointcut and Advisor to intercept a method via it’s method name.
 */
public class MainApp {
	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				new String[] { "spring-aop-aspectJ-annotation.xml" });
 
		// Simple (No Advise)
		Customer customer = (Customer) appContext.getBean("customer");
		 
		System.out.println("*************************");
		customer.printName();
		System.out.println("*************************");
		customer.printURL();
		System.out.println("*************************");
		customer.addInteger();
		System.out.println("*************************");
		customer.addCustomerAround("Skumar");
		System.out.println("*************************");
		
		try {
			//cust.printThrowException();
		} catch (Exception e) {
			e.printStackTrace();
		}


		
	}
	
}