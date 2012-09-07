package com.skumar.spring.core.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.skumar.spring.core.bean.Customer;


/*
 In Spring, bean scope is used to decide which type of bean instance should be return from Spring container back to the caller.

5 types of bean scopes supported :

singleton – Return a single bean instance per Spring IoC container
prototype – Return a new bean instance each time when requested
request – Return a single bean instance per HTTP request. *
session – Return a single bean instance per HTTP session. *
globalSession – Return a single bean instance per global HTTP session. *
In most cases, you may only deal with the Spring’s core scope – singleton and prototype, and the default scope is singleton.
*/




public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean-scope.xml");
		///START: default i.e. singleton
		Customer customer1 = (Customer)context.getBean("customer");
		customer1.setMessage("Hello...:");
		System.out.println(customer1.getMessage()); 
		
		Customer customer2 = (Customer)context.getBean("customer");
		
		//Output will be Hello when bean scope is either default or singleton, and null when bean scope is prototype in spring-bean-scope.xml
		System.out.println(customer2.getMessage()); 
	}
}
