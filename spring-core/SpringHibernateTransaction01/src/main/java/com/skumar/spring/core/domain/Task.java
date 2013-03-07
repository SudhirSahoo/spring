package com.skumar.spring.core.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name = "com.skumar.spring.core.domain.Task")
@Table(name = "task")
public class Task {
	private Integer id;
	private String name;
	private String description;
	
	public Task() {
		
	}
	
	public Task(Integer id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
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
	
	@Column(name = "description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
