package com.skumar.spring.web.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.skumar.spring.web.validator.CreateTaskValidator;
import com.skumar.tms.hibernate.domain.CreateTask;

@Controller
@RequestMapping("/task")
public class CreateTaskController {

	@Autowired
	CreateTaskValidator createTaskValidator;
	
	@RequestMapping("/createTaskLandingPage.do")
	public String landingPage(ModelMap model, HttpServletRequest request) {
		System.out.println("TASKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK...");
		CreateTask createTask = new CreateTask();
		createTask.setTaskDesc("Go Home");
		
		/*List<String> taskPriorityList = new ArrayList<String>();
		taskPriorityList.add("Critical");
		taskPriorityList.add("High");
		taskPriorityList.add("Medium");
		taskPriorityList.add("Low");		
		request.setAttribute("taskPriorityList", taskPriorityList);
		
		Map taskPriorityMap = new HashMap();
		taskPriorityMap.put("1", "Critical");
		taskPriorityMap.put("2", "High");
		taskPriorityMap.put("3", "Medium");
		taskPriorityMap.put("4", "Low");
		request.setAttribute("taskPriorityMap", taskPriorityMap);
		
		Map taskStatusMap = new HashMap();
		taskStatusMap.put("1", "Backlog");
		taskStatusMap.put("2", "New");
		taskStatusMap.put("3", "Open");
		taskStatusMap.put("4", "Paused");
		taskStatusMap.put("5", "In Progress");
		taskStatusMap.put("6", "Paused");
		taskStatusMap.put("7", "Verifying");
		taskStatusMap.put("9", "Verified");
		taskStatusMap.put("10", "Closed");
		request.setAttribute("taskStatusMap", taskStatusMap);
		*/
		createTask.setTaskPriority("3");
		createTask.setTaskCreatedDate(new Date());
		//createTask
		model.addAttribute("createTask", createTask);
		return "createTask-tiles";
	}
	
	
	@RequestMapping(value="/createTask.do", method = RequestMethod.POST)
	public String saveTask(@ModelAttribute("createTask")CreateTask createTask, BindingResult result, SessionStatus status) {
		System.out.println("ON SUBMIT........................................" + createTask.getTaskName() + "      Desc: " + createTask.getTaskDesc());
		createTaskValidator.validate(createTask, result);
		if (result.hasErrors()) {
			System.out.println("ERRORRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR...");
			return "createTask-tiles";
		} else {
			return "createTask-tiles";
		}
		
	}


	public void setCreateTaskValidator(CreateTaskValidator createTaskValidator) {
		this.createTaskValidator = createTaskValidator;
	}
	
	@ModelAttribute("taskPriorityMap")
	protected Map<String, String> populateTaskPriorityMap() {
		
		Map<String, String> taskPriorityMap = new HashMap<String, String>();
		taskPriorityMap.put("1", "Critical");
		taskPriorityMap.put("2", "High");
		taskPriorityMap.put("3", "Medium");
		taskPriorityMap.put("4", "Low");
		
		return taskPriorityMap;
	}
	
	@ModelAttribute("taskStatusMap")
	protected Map<String, String> populateTaskStatusMap() {
		Map<String, String> taskStatusMap = new HashMap<String, String>();
		taskStatusMap.put("1", "Backlog");
		taskStatusMap.put("2", "New");
		taskStatusMap.put("3", "Open");
		taskStatusMap.put("4", "Paused");
		taskStatusMap.put("5", "In Progress");
		taskStatusMap.put("6", "Paused");
		taskStatusMap.put("7", "Verifying");
		taskStatusMap.put("9", "Verified");
		taskStatusMap.put("10", "Closed");
		
		return taskStatusMap;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) 
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
}
