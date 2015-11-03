package com.clocker.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.clocker.service.ForgotPasswordService;


@Controller
public class HomeController extends AbstractPageController{
	

	private static final Logger log=Logger.getLogger(HomeController.class.getName());
	
	
	@Autowired
	@Qualifier("forgotPasswordService")
	private ForgotPasswordService forgotPasswordService;
	
	
	@RequestMapping("/")
	public String rootPage(Model model)
	{
		return "redirect:/login";
	}
	
	@RequestMapping("/login")
	public String login(Model model,@RequestParam(value="error",required=false)String error)
	{
		if(error!=null)
			model.addAttribute("errorMessage", "There was a problem with the login. Please try again or click forgot password.");
		
		return "layouts/login";
	}
	
	
	@RequestMapping(value="/forgotpassword",method=RequestMethod.GET)
	public String forgotpasswordGet(Model model,@RequestParam(value="error",required=false)String error)
	{
		
		if(error!=null)
			model.addAttribute("errorMessage", "Please enter a valid email id");
		
		return "layouts/forgotpassword";
	}
	
	@RequestMapping(value="/forgotpassword",method=RequestMethod.POST)
	public String forgotpasswordPost(Model model,@RequestParam(value="error",required=false)String error,@RequestParam(value="email",required=false)String email)
	{
		if(email==null || email.isEmpty())
		{
			return "redirect:/forgotpassword?error=1";
		}
		else
		{
			try {
				forgotPasswordService.sendForgotPasswordEmail(email);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				log.info(e.getLocalizedMessage());
				e.printStackTrace();
				model.addAttribute("errorMessage", "we had a technical problem");
			}
		}
		if(error!=null)
			model.addAttribute("errorMessage", "Please enter a valid email id");
		
		return "layouts/forgotpassword";
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
