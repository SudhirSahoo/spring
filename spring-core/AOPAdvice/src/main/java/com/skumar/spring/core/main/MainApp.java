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
				new String[] { "Spring-aop-advice.xml" });
 
		// Simple (No Advise)
		System.out.println("=======================================================================================");
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

		
		// Before Advise
		System.out.println("\n\n\n\n=======================================================================================");
		System.out.println("---: START: BEFORE ADVICE :---");
		Customer customerProxyBefore = (Customer) appContext.getBean("customerProxyBefore");
 
		System.out.println("*************************");
		customerProxyBefore.printName();
		System.out.println("*************************");
		customerProxyBefore.printURL();
		System.out.println("*************************");
		try {
			//cust.printThrowException();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("---: END: BEFORE ADVICE :---");
		
		System.out.println("\n\n\n\n=======================================================================================");
		System.out.println("---: START: AFTER ADVICE :---");
		Customer customerProxyAfter = (Customer) appContext.getBean("customerProxyAfter");
		 
		System.out.println("*************************");
		customerProxyAfter.printName();
		System.out.println("*************************");
		customerProxyAfter.printURL();
		System.out.println("*************************");
		try {
			//cust.printThrowException();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("---: END: AFTER ADVICE :---");

		
		System.out.println("\n\n\n\n=======================================================================================");
		System.out.println("---: START: THROW EXCEPTION :---");
		Customer customerProxyThrowException = (Customer) appContext.getBean("customerProxyThrowException");
		 
		System.out.println("*************************");
		customerProxyThrowException.printName();
		System.out.println("*************************");
		customerProxyThrowException.printURL();
		System.out.println("*************************");
		//cust.throwException();
		try {
			customerProxyThrowException.printThrowException();
		} catch (Exception e) {
			//e.printStackTrace();
		}
		System.out.println("---: END: THROW EXCEPTION :---");

		
		System.out.println("\n\n\n\n=======================================================================================");
		System.out.println("---: START: AROUND ADVICE :---");
		Customer customerProxyAround = (Customer) appContext.getBean("customerProxyAround");
		 
		System.out.println("*************************");
		customerProxyAround.printName();
		System.out.println("*************************");
		customerProxyAround.printURL();
		System.out.println("*************************");
		try {
			customerProxyAround.printThrowException();
		} catch (Exception e) {
			//e.printStackTrace();
		}
		System.out.println("---: END: AROUND ADVICE :---");

		
	}
	
}