package com.skumar.spring.core.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.skumar.spring.core.dao.CustomerDAO;
import com.skumar.spring.core.model.Customer;

public class MainApp {
	 public static void main( String[] args )
	    {
	    	ApplicationContext context = 
	    		new ClassPathXmlApplicationContext("Spring-Module.xml");
	 
	        CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
	        Customer customer = new Customer(11, "SKumar 11", 31);
	        customerDAO.insert(customer);
	        //customerDAO.insertUsingJdbcTemplate(customer);
	 
	        Customer customer1 = customerDAO.findByCustomerId(7);
	        //Customer customer1 = customerDAO.findByCustomerIdUsingJdbcTemplate(11);
	        System.out.println(customer1.getName());
	 
	    }
}
