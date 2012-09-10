package com.skumar.spring.core.main;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.skumar.spring.core.bean.Customer;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-factorybean.xml");

		Customer cust = (Customer) context.getBean("customer");
		
		//List
		List<Object> lists = cust.getLists();
		System.out.println("LIST:");
		for(Object list:lists) {
			System.out.println(list.toString());
		}
		
		System.out.println("\n");
		
		//Set
		Set<Object> sets = cust.getSets();
		System.out.println("SET:");
		for(Object set:sets) {
			System.out.println(set.toString());
		}
		
		
		//Map
		System.out.println("MAP:");
		Map<Object, Object> items = cust.getMaps();
		for (Map.Entry<Object, Object> entry : items.entrySet()) {
		    String key = (String)entry.getKey();
		    String value = (String)entry.getValue();
		    System.out.println("Key: " + key + " - Value:" + value);
		}
		
	}
}
