package com.skumar.spring.core.service;

import com.skumar.spring.core.domain.Associate;
import com.skumar.spring.core.domain.Task;

public interface TaskService {
	public Task getTask(Integer taskId);
	
	public Integer createTask(Task task);
	
	public Integer createAssociate(Associate associate);
	
	public String createTaskAndAssociate(Task task, Associate associate);
}
