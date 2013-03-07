package com.skumar.spring.core.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.skumar.spring.core.domain.Associate;
import com.skumar.spring.core.domain.Task;
import com.skumar.spring.core.service.TaskService;

public class MainApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-core.xml");
		
		TaskService taskService = (TaskService)context.getBean("taskService");
		
		//Task task = taskService.getTask(11);
		//System.out.println(task.getName());
		
		//Task task1 = new Task(1, "Go Home 1", "Do Not Work 1");
		//Integer taskId = taskService.createTask(task1);
		//System.out.println("Created Task Id: " + taskId);
		
		//Associate associate1 = new Associate(2, "Skumar ", "Mumbai 2");
		//taskService.createAssociate(associate1);
		
		
		int id = 27;
		Task task2 = new Task(id, "Go Home"+id, "Do Not Work "+id);
		Associate associate2 = new Associate(id, "Skumar "+id, "Mumbai "+id);
		String taskAndAssoiate = taskService.createTaskAndAssociate(task2, associate2);
		System.out.println("Create Task and Associate: " + taskAndAssoiate);
	}

}
