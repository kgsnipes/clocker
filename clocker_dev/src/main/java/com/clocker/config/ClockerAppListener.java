package com.clocker.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.clocker.service.BootstrapService;


@Component
public class ClockerAppListener implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	private BootstrapService bootstrapService;
	
    public void onApplicationEvent(ContextRefreshedEvent event) {
    	bootstrapService.performBootstrapActivities();
    }

}
