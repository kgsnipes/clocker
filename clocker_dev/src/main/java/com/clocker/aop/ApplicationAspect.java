package com.clocker.aop;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ApplicationAspect {
	
	private static final Logger log=Logger.getLogger(ApplicationAspect.class.getName());
	
	@AfterReturning("execution(* *onStartup(..))")
	public Object doBootstrapActivities(JoinPoint joinPoint)
	{
		log.info("details : "+joinPoint.getSignature());
		log.info("Doing the bootstrap activities-------------------------------------");
		return joinPoint;
	}

}
