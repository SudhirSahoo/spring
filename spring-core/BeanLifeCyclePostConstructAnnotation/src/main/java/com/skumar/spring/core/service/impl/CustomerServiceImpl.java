package com.skumar.spring.core.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class CustomerServiceImpl 
{
	String message;
 
	public String getMessage() {
	  return message;
	}
 
	public void setMessage(String message) {
		System.out.println("Setting properties..." + message);
	  this.message = message;
	}
 
	@PostConstruct
	public void afterPropertiesSet() throws Exception {
	  System.out.println("Init method after properties are set : " + message);
	}
 
	@PreDestroy
	public void destroy() throws Exception {
	  System.out.println("Spring Container is destroy! Customer clean up");
	}
	
}