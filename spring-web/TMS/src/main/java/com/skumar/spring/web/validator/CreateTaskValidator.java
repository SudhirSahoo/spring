package com.skumar.spring.web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.skumar.spring.web.form.CreateTaskForm;


public class CreateTaskValidator implements Validator {

	public boolean supports(Class clazz) {
		return CreateTaskForm.class.isAssignableFrom(clazz);
	}
	
	public void validate(Object target, Errors errors) {
 
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "taskName",
			"required.taskName", "Field name is required.");
	}
}
