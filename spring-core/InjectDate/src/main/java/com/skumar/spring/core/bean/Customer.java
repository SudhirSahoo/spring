package com.skumar.spring.core.bean;

import java.util.Date;

public class Customer {

	Date date;
	Date date2;
	 
	public Date getDate() {
		return date;
	}
 
	public void setDate(Date date) {
		this.date = date;
	}
 
	
	public Date getDate2() {
		return date2;
	}

	public void setDate2(Date date2) {
		this.date2 = date2;
	}

	@Override
	public String toString() {
		return "Customer [date=" + date + "]";
	}

}
