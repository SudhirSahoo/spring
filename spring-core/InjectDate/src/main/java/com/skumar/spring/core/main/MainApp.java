package com.skumar.spring.core.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.skumar.spring.core.bean.Customer;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-inject-date.xml");

		Customer cust = (Customer) context.getBean("customer");
		System.out.println(cust.getDate());
		System.out.println(cust.getDate2());
		
		//cust.getLists();
	}
}
