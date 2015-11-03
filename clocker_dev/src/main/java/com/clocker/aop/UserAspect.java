package com.clocker.aop;

import java.security.MessageDigest;
import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.clocker.dto.UserDTO;

@Component
@Aspect
public class UserAspect {
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	private static final Logger log=Logger.getLogger(UserAspect.class.getName());
	
	@Around("execution(* *createUser(..))")
    public Object userPasswordEncryption(ProceedingJoinPoint pjp) throws Throwable {
        // start stopwatch
		
		log.info("performing the password encryption during creation of a user.");
		UserDTO user=(UserDTO)pjp.getArgs()[0];
		user.setPassword(new String(encodePWD(user.getPassword())));
        return pjp.proceed(new Object[]{user,pjp.getArgs()[1]});
    }
	
	protected String encodePWD(String pwd) 
	{
		String result=null;
		try
		{
		
		result= encoder.encode(pwd);
		log.info("encoded pwd "+ result);
		}
		catch(Exception ex)
		{
			log.severe(ex.getMessage());
		}
		return result;
		
	}

}
