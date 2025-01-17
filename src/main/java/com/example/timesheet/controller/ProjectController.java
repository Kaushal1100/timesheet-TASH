package com.example.timesheet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin(origins = "http://localhost:5173", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
@Controller
public class ProjectController {
	
				//First Create Controller mapping for each of the pages: home, admin/home and user/home
//		@GetMapping("/home")
//		  public String handleWelcome() {
//		    return "home";
//		  }
//
//		  @GetMapping("/admin/home")
//		  public String handleAdminHome() {
//		    return "home_admin";
//		  }
//
//		  @GetMapping("/user/home")
//		  public String handleUserHome() {
//		    return "home_user";
//		  }
		  
		  @GetMapping("/login")
		  public String handleLogin() {
			  return "Login"; //same name as the fileName
		  }
		  @GetMapping("/success")
		  public String handleSuccess() {
			  return "success";
		  }

		}
