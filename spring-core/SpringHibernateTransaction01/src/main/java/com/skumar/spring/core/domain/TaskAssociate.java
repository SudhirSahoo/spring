package com.skumar.spring.core.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "com.skumar.spring.core.domain.TaskAssociate")
@Table(name = "task_associate")
public class TaskAssociate {
	private Integer id;
	private Integer taskId;
	private Integer associateId;
	
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true)
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "task_id")
	public Integer getTaskId() {
		return taskId;
	}
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	
	@Column(name = "associate_id")
	public Integer getAssociateId() {
		return associateId;
	}
	public void setAssociateId(Integer associateId) {
		this.associateId = associateId;
	}
	
	
}
