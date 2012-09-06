package com.skumar.spring.core.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.skumar.spring.core.bean.HelloWorld;
import com.skumar.spring.core.config.AppConfig;

public class App {
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		HelloWorld obj = (HelloWorld) context.getBean("helloWorldBean");

		obj.printHelloWorld("Spring3 Java Annotation Config");

	}
}
