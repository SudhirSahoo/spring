package com.skumar.spring.web.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping("/authenticate")
public class AuthenitcationController {
	
/*
 	private List<User> userList = new ArrayList<User>();
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody JsonResponse  login(@ModelAttribute(value = "user") User user, BindingResult result) {
		System.out.println(user.getUserName());
		// Do your stuff here... i.e call Hibernate etc...
		
		JsonResponse res = new JsonResponse();
		ValidationUtils.rejectIfEmpty(result, "userName", "Username can not be empty.");
		ValidationUtils.rejectIfEmpty(result, "userPassword", "Passowrd can not be empty");
		if (!result.hasErrors()) {
			userList.add(user);
			res.setStatus("SUCCESS");
			res.setResult(userList);
		} else {
			res.setStatus("FAIL");
			res.setResult(result.getAllErrors());
		}

		return res;
	}
	*/
	
	@RequestMapping(value = "/performLogin", method=RequestMethod.POST)
	@ResponseBody
	public String performLogin(@RequestParam("userName") String username, 
			@RequestParam("userPassword") String password,
			HttpServletRequest request, HttpServletResponse response) 
	{
		System.out.println("....................performLogin");
		//String username="frank";
		//String password="12345";
		System.out.println("Username: " + username + "       " + password);
		UsernamePasswordAuthenticationToken token = 
			new UsernamePasswordAuthenticationToken(username, password);
		try {
			Authentication auth = authenticationManager.authenticate(token);
			SecurityContextHolder.getContext().setAuthentication(auth);
			request.setAttribute("uid", "AAAAAAAA");
			repository.saveContext(SecurityContextHolder.getContext(), request, response);
			rememberMeServices.loginSuccess(request, response, auth);
			User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			Collection<GrantedAuthority> list = auth.getAuthorities();
			for(GrantedAuthority ga:list) {
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> " + ga.getAuthority());
			}
			System.out.println("SUCCESS..." + auth.getName() + "      Role: " );
			return "{\"status\": true}";
		} catch (BadCredentialsException ex) {
			System.out.println(ex.getMessage());
			return "{\"status\": false, \"error\": \"Bad Credentials\"}";
		}
	}

	@Autowired
	@Qualifier("authenticationManager")
	AuthenticationManager authenticationManager;
	
	@Autowired
	SecurityContextRepository repository;
	
	@Autowired
	RememberMeServices rememberMeServices;
	
}
