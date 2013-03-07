package com.skumar.spring.core.dao;

import com.skumar.spring.core.model.Customer;

public interface CustomerDAO {
	
	public void insert(Customer customer);

	public Customer findByCustomerId(int custId);
	
	public void insertUsingJdbcTemplate(Customer customer);
	
	public Customer findByCustomerIdUsingJdbcTemplate(int custId);
}
