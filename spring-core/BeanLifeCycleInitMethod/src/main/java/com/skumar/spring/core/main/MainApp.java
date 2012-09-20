package com.skumar.spring.core.main;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.skumar.spring.core.service.impl.CustomerServiceImpl;

/*
	In Spring, you can use init-method and destroy-method as attribute in bean configuration file for bean to perform certain actions upon initialization and destruction. 
	Alternative to InitializingBean and DisposableBean interface.
	
	It’s always recommended to use init-method and destroy-method in bean configuration file, 
	instead of implement the InitializingBean and DisposableBean interface to cause unnecessarily coupled your code to Spring.
 */

public class MainApp {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-beanLifeCycle-init-method.xml");
		//AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-beanLifeCycle-init-method.xml");
		CustomerServiceImpl output = (CustomerServiceImpl)context.getBean("customer");
        System.out.println(output);
        
        //context.registerShutdownHook();
        context.close();
	}
}
