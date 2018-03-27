package com.skumar.iqs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by vfc01875 on 7/7/2017.
 */
@RestController
public class DashboardController {
    
	@RequestMapping(value = "/api/dashboard", method = RequestMethod.GET)
    public String init(){
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>Dashboard - init()");
        return "dashboard_init";
    }
}
