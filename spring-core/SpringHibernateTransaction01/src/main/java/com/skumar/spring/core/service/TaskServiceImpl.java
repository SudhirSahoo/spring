package com.skumar.spring.core.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.skumar.spring.core.dao.AssociateDAO;
import com.skumar.spring.core.dao.TaskDAO;
import com.skumar.spring.core.domain.Associate;
import com.skumar.spring.core.domain.Task;

public class TaskServiceImpl implements TaskService{
	
	@Autowired
	AssociateDAO associateDAO;
	
	@Autowired
	Task task;
	
	@Autowired
	TaskDAO taskDAO;
	
	public Task getTask(Integer taskId) {
		System.out.println("Hello...");
		task = taskDAO.getTask(taskId);
		
		return task;
	}

	
	public Integer createTask(Task task) {
		Integer taskId = taskDAO.createTask(task);
		return taskId;
	}
	
	public Integer createAssociate(Associate associate) {
		Integer associateId = associateDAO.createAssociate(associate);
		return associateId;
	}

	/*public String createTaskAndAssociate(Task task, Associate associate) {
		Integer taskId = taskDAO.createTask(task);
		String str = null;
		str.trim();
		Integer associateId = taskDAO.createAssociate(associate);
		
		return taskId + " | " + associateId;
	}*/
	
	
	public String createTaskAndAssociate(Task task, Associate associate) {
		
		System.out.println(taskDAO.getClass().getName());
		
		String taskId = taskDAO.createTask(task, associate);
		
		//Integer taskId = taskDAO.createTask(task);
		//Integer associateId = taskDAO.addAssociate(associate);
		
		return taskId+"";
	}
	
	
	
}
