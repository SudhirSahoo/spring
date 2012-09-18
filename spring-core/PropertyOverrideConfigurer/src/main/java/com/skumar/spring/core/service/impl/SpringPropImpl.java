package com.skumar.spring.core.service.impl;

import com.skumar.spring.core.service.SpringProp;

public class SpringPropImpl {//implements SpringProp {
	private String userName;
	private String password;

	public SpringPropImpl() {
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}