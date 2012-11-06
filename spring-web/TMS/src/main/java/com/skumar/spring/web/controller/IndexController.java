package com.skumar.spring.web.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/indexPage")
public class IndexController {
	
	@RequestMapping("/landing")
	public String indexHandler(ModelMap model, Principal principal) {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		if(null != principal) {
			String name = principal.getName();
			model.addAttribute("username", name);
			System.out.println("UserName: " + name);
		}
		return "indexPage-tiles";
	}
}
