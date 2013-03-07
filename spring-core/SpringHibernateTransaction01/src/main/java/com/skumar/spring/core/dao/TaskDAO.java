package com.skumar.spring.core.dao;

import com.skumar.spring.core.domain.Associate;
import com.skumar.spring.core.domain.Task;

public interface TaskDAO {
	public Task getTask(Integer taskId);

	public Integer createTask(Task task);
	
	public Integer createAssociate(Associate associate);
	
	public Integer addAssociate(Associate associate);
	
	public String createTask(Task task, Associate associate);
}
