package com.clocker.service.impl;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clocker.service.BootstrapFragment;
import com.clocker.service.BootstrapService;

@Component
public class DefaultBootstrapService implements BootstrapService{

	private static final Logger log=Logger.getLogger(DefaultBootstrapService.class.getName());
	
	@Autowired
	List<BootstrapFragment> bootstrapTaskList;
	
	
	@Override
	public void performBootstrapActivities() {
		
		for(BootstrapFragment fragment:bootstrapTaskList)
		{
			log.info("Performing a bootstrap fragment");
			try
			{
				fragment.performTask();
			}
			catch(Exception ex)
			{
				log.severe(ex.getLocalizedMessage());
			}
		}
		
	}

}
