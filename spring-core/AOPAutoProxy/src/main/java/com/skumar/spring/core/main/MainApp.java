package com.skumar.spring.core.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.skumar.spring.core.bean.Customer;
import com.skumar.spring.core.bean.CustomerService;
import com.skumar.spring.core.bean.ItemService;;

/*
 NOTE: In this example, all the methods in a customer service class are intercepted (advice) automatically. 
 But for most cases, you may need to use Pointcut and Advisor to intercept a method via it’s method name.
 */
public class MainApp {
	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				new String[] { "spring-aop-autoproxy.xml" });
 
		// AutoProxyCreator
		System.out.println("=======================================================================================");
		System.out.println("---: START: AutoProxyCreator :---");
		//Customer obj = (Customer) appContext.getBean("customer");
		//CustomerService obj = (CustomerService) appContext.getBean("customerService");
		ItemService obj = (ItemService) appContext.getBean("itemService");
 
		System.out.println("*************************");
		obj.printName();
		System.out.println("***************************************************");
		obj.printURL();
		System.out.println("*************************");
		try {
			//cust.printThrowException();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("---: END: AutoProxyCreator :---");
		
	}	
}