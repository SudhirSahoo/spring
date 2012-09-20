package com.skumar.spring.core.service.impl;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class CustomerServiceImpl //implements InitializingBean, DisposableBean
{
	String message;
 
	public String getMessage() {
	  return message;
	}
 
	public void setMessage(String message) {
		System.out.println("Setting properties..." + message);
	  this.message = message;
	}
 
	public void afterPropertiesSet() throws Exception {
	  System.out.println("Init method after properties are set : " + message);
	}
 
	public void destroy() throws Exception {
	  System.out.println("Spring Container is destroy! Customer clean up");
	}
 
	public void initialize() throws Exception {
		  System.out.println("Initialize method after properties are set : " + message);
		}
}