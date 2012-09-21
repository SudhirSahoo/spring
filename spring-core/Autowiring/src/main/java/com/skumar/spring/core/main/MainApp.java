package com.skumar.spring.core.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.skumar.spring.core.bean.Customer;
import com.skumar.spring.core.bean.CustomerAutoDetect;
import com.skumar.spring.core.bean.CustomerByType;
import com.skumar.spring.core.bean.CustomerConstructor;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-autowiring-byName.xml");
		Customer customer = (Customer) context.getBean("customer");
		System.out.println("By Name: " + customer.getAddress().getFullAddress());


		ApplicationContext contextByType = new ClassPathXmlApplicationContext(
				"spring-autowiring-byName.xml");
		CustomerByType customerByType = (CustomerByType) contextByType.getBean("customerByType");
		System.out.println("By Type: " + customerByType.getAddress().getFullAddress());


		ApplicationContext contextConstructor = new ClassPathXmlApplicationContext(
				"spring-autowiring-byName.xml");
		CustomerConstructor customerConstructor = (CustomerConstructor) context.getBean("customerConstructor");
		System.out.println("Constructor: " + customerConstructor.getAddress().getFullAddress());


		ApplicationContext contextAutoDetect = new ClassPathXmlApplicationContext(
				"spring-autowiring-byName.xml");
		CustomerAutoDetect customerAutoDetect = (CustomerAutoDetect) context.getBean("customerAutoDetect");
		System.out.println("AutoDetect: " + customerAutoDetect.getAddress().getFullAddress());
	
	}

}
