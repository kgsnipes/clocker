package com.clocker.controller;

import java.util.Locale;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clocker.service.UserService;


@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	 @Value("${sample.message}")
	 private String someMessage;
	 
	 @Autowired
	 private MessageSource messageSource;
	 
	private static final Logger log=Logger.getLogger(HomeController.class.getName());
	
	
	@RequestMapping("/login")
	public String homePage(Model model)
	{
		
		model.addAttribute("message", someMessage);
		return "showMessage";
	}

}
