package com.skumar.spring.core.bean.impl;

import com.skumar.spring.core.bean.IOutputGenerator;

public class CsvOutputGenerator implements IOutputGenerator {
	public void generateOutput() {
		System.out.println("This is Csv Output Generator");
	}
}