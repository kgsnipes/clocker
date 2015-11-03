package com.clocker.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.clocker.service.BootstrapFragment;
import com.clocker.service.impl.CustomerDataBootstrapFragment;

@Component
@Configuration
public class ApplicationConfig {
	
	@Bean
	public List<BootstrapFragment> bootstrapTaskList()
	{
		List<BootstrapFragment> taskList= new ArrayList<BootstrapFragment>();
		taskList.add(new CustomerDataBootstrapFragment());
		return taskList;
	}
	
	@Bean
	public BCryptPasswordEncoder encoder()
	{
		return new BCryptPasswordEncoder(11);
	}
}
