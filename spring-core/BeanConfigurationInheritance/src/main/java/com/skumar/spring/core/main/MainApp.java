package com.skumar.spring.core.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.skumar.spring.core.bean.ComputerDepartment;
import com.skumar.spring.core.bean.Department;

public class MainApp {


	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean-configuration-inheritance.xml");
		Department dept = (Department)context.getBean("deparment");
		System.out.println(dept);

		ComputerDepartment compDept = (ComputerDepartment)context.getBean("compDeparment");
		System.out.println(compDept);
}

}
