package com.clocker.controller;

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
	

	private static final Logger log=Logger.getLogger(HomeController.class.getName());
	
	
	@RequestMapping("/")
	public String rootPage(Model model)
	{
		return "redirect:/login";
	}
	
	@RequestMapping("/login")
	public String login(Model model)
	{
		
		
		return "layouts/login";
	}
	
	@RequestMapping("/logout")
	public String logout(Model model)
	{
		
		
		return "layouts/login";
	}
	
	@RequestMapping("/app")
	public String appHome(Model model)
	{
		
		
		return "layouts/appHome";
	}

}
