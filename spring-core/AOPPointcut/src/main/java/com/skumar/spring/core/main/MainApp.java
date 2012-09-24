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
				new String[] { "spring-aop-pointcut.xml" });
 
		// Simple (No Advise)
		Customer customer = (Customer) appContext.getBean("customer");
		 
		System.out.println("*************************");
		customer.printName();
		System.out.println("*************************");
		customer.printURL();
		System.out.println("*************************");
		try {
			//cust.printThrowException();
		} catch (Exception e) {
			e.printStackTrace();
		}


		System.out.println("---: START: NAME MATCH POINTCUT ADVISOR :---");
		Customer customerProxyAround = (Customer) appContext.getBean("customerProxyAroundnameMatch");
		 
		System.out.println("*************************");
		customerProxyAround.printName();
		System.out.println("*************************");
		customerProxyAround.printURL();
		System.out.println("*************************");
		try {
			//customerProxyAround.printThrowException();
		} catch (Exception e) {
			//e.printStackTrace();
		}
		System.out.println("---: END: NAME MATCH POINTCUT ADVISOR :---");
		System.out.println("=======================================================================================");
		
		
		System.out.println("\n\n\n---: START: REGULAR EXPRESSION POINTCUT ADVISOR :---");
		Customer customerProxyAroundRegEx = (Customer) appContext.getBean("customerProxyAroundRegEx");
		 
		System.out.println("*************************");
		customerProxyAroundRegEx.printName();
		System.out.println("*************************");
		customerProxyAroundRegEx.printURL();
		System.out.println("*************************");
		try {
			//customerProxyAround.printThrowException();
		} catch (Exception e) {
			//e.printStackTrace();
		}
		System.out.println("---: END: REGULAR EXPRESSION POINTCUT ADVISOR :---");
		

		
	}
	
}