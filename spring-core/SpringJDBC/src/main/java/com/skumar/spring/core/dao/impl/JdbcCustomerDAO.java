package com.skumar.spring.core.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import com.skumar.spring.core.dao.CustomerDAO;
import com.skumar.spring.core.model.Customer;
import com.skumar.spring.core.model.CustomerRowMapper;

public class JdbcCustomerDAO implements CustomerDAO {  //extends SimpleJdbcDaoSupport
	private DataSource dataSource;

	// JdbcTemplate - Using JdbcTemplate.  NOTE: when you are extending SimpleJdbcDaoSupport this JdbcTemplate is NOT required
	private JdbcTemplate jdbcTemplate;
	
	// Comment the below code when you extend SimpleJdbcDaoSupport
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insert(Customer customer) {

		String sql = "INSERT INTO CUSTOMER "
				+ "(CUST_ID, NAME, AGE) VALUES (?, ?, ?)";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, customer.getCustId());
			ps.setString(2, customer.getName());
			ps.setInt(3, customer.getAge());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	public Customer findByCustomerId(int custId) {

		String sql = "SELECT * FROM CUSTOMER WHERE CUST_ID = ?";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, custId);
			Customer customer = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				customer = new Customer(rs.getInt("CUST_ID"), rs.getString("NAME"), rs.getInt("Age"));
			}
			rs.close();
			ps.close();
			return customer;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}
	
	
	public void insertUsingJdbcTemplate(Customer customer) {

		String sql = "INSERT INTO CUSTOMER "
				+ "(CUST_ID, NAME, AGE) VALUES (?, ?, ?)";
		
		//NOTE: when you are extending SimpleJdbcDaoSupport this JdbcTemplate is NOT required.
		jdbcTemplate = new JdbcTemplate(dataSource);
		
		jdbcTemplate.update(sql, new Object[] { customer.getCustId(),
				customer.getName(),customer.getAge()  
			});
		
		// Uncomment when you are extending SimpleJdbcDaoSupport
		/*getJdbcTemplate().update(sql, new Object[] { customer.getCustId(),
				customer.getName(),customer.getAge()  
			});*/
	}

	public Customer findByCustomerIdUsingJdbcTemplate(int custId) {

		String sql = "SELECT * FROM CUSTOMER WHERE CUST_ID = ?";
		
		//NOTE: when you are extending SimpleJdbcDaoSupport this JdbcTemplate is NOT required
		jdbcTemplate = new JdbcTemplate(dataSource);
		
		Customer customer = (Customer)jdbcTemplate.queryForObject(
				sql, new Object[] { custId }, new CustomerRowMapper());
		
		// Uncomment when you are extending SimpleJdbcDaoSupport
		/*Customer customer = (Customer)getJdbcTemplate().queryForObject(
				sql, new Object[] { custId }, new CustomerRowMapper());
		*/
		
		return customer;
		
	}
}
