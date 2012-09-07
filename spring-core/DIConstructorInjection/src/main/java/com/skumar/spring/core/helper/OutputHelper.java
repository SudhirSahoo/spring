package com.skumar.spring.core.helper;

import com.skumar.spring.core.bean.IOutputGenerator;

public class OutputHelper {
	
	IOutputGenerator outputGenerator;
	 
	public void generateOutput() {
		outputGenerator.generateOutput();
	}
 
	//DI via constructor
	public OutputHelper(IOutputGenerator outputGenerator){
		this.outputGenerator = outputGenerator;
	}
	
	
/*	
    private String name;
	private String address;
	private int age;
 
	public OutputHelper(String name, String address, int age) {
		this.name = name;
		this.address = address;
		this.age = age;
	}
 
	public OutputHelper(String name, int age, String address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}
	
	
	//getter and setter methods
		public String toString(){
			return " name : " +name + "\n address : "
	               + address + "\n age : " + age;
		}
	*/
	
/* // Inject Value Into Bean. XML: <property name="message" value="Hello"></property>
	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
*/
	
	
}
