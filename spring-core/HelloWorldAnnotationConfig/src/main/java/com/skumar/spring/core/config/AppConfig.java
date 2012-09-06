package com.skumar.spring.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.skumar.spring.core.bean.HelloWorld;
import com.skumar.spring.core.bean.impl.HelloWorldImpl;


// Here you can import another configuration class. e.g. @Import({ CustomerConfig.class, SchedulerConfig.class })
@Configuration
public class AppConfig {
 
	
	// Here default name of bean is "helloWorld", i.e. the method name.
    @Bean(name="helloWorldBean")
    public HelloWorld helloWorld() {
        return new HelloWorldImpl();
    }
 
}
