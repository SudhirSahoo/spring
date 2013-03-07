package com.skumar.spring.web.form;

import java.util.Date;

import com.skumar.tms.hibernate.domain.CreateTask;

public class CreateTaskForm {
	private CreateTask createTask;
	private String taskName;
	private String taskDesc;
	private Date taskCreatedDate;

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskDesc() {
		return taskDesc;
	}

	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}
	
	public CreateTask getCreateTask() {
		return createTask;
	}

	public void setCreateTask(CreateTask createTask) {
		this.createTask = createTask;
	}

	public Date getTaskCreatedDate() {
		return taskCreatedDate;
	}

	public void setTaskCreatedDate(Date taskCreatedDate) {
		this.taskCreatedDate = taskCreatedDate;
	}
	
	
}
