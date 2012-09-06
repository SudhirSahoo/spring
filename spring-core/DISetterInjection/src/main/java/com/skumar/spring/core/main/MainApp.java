package com.skumar.spring.core.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.skumar.spring.core.helper.OutputHelper;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-dipendency-injection.xml");
		OutputHelper output = (OutputHelper)context.getBean("outputHelper");
        output.generateOutput();
	}
}
