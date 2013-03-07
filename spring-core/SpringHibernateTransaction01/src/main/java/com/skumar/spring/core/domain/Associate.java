package com.skumar.spring.core.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "com.skumar.spring.core.domain.Associate")
@Table(name = "associate")
public class Associate {
	private Integer id;
	private String name;
	private String address;
	
	public Associate() {
		
	}
	
	public Associate(Integer id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
    @Id
    @Column(name = "id", unique = true)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "address")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
