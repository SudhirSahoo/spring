package com.skumar.spring.core.helper;

import com.skumar.spring.core.bean.IOutputGenerator;

public class OutputHelper {
	
	IOutputGenerator outputGenerator;
	 
	public void generateOutput() {
		outputGenerator.generateOutput();
	}
 
	//DI via setter method
	public void setOutputGenerator(IOutputGenerator outputGenerator) {
		this.outputGenerator = outputGenerator;
	}
}
