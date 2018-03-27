package com.skumar.iqs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by vfc01875 on 7/7/2017.
 */
@Controller
public class LoginController {
    @RequestMapping("/login")
    String login(){
        return "login";
    }
}
