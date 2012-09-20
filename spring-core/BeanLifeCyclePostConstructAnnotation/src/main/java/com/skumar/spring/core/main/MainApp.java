package com.skumar.spring.core.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.skumar.spring.core.service.impl.CustomerServiceImpl;

/*
	
 */

public class MainApp {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-beanLifeCycle-Annotation.xml");
		CustomerServiceImpl output = (CustomerServiceImpl)context.getBean("customer");
        System.out.println(output);
        
        context.close();
	}
}
