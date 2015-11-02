package com.clocker.aop;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.clocker.dto.UserDTO;

//@Component
//@Aspect
public class UserAspect {
	
	private static final Logger log=Logger.getLogger(UserAspect.class.getName());
	
	@Around("execution(* *createUser(..))")
    public Object userPasswordEncryption(ProceedingJoinPoint pjp) throws Throwable {
        // start stopwatch
		
		log.info("performing the password encryption during creation of a user.");
		UserDTO user=(UserDTO)pjp.getArgs()[0];
		user.setPassword(new String(encodePWD(user.getPassword())));
        return pjp.proceed(new Object[]{user,pjp.getArgs()[1]});
    }
	
	@AfterReturning(pointcut="execution(* org.springframework.security.core.*.getCredentials(..))", returning="returnString")
    public Object getNameReturningAdvice(String returnString){
		return encodePWD(returnString);
    }
	
	protected String encodePWD(String pwd) 
	{
		String result=null;
		try
		{
		byte[] bytesOfMessage = pwd.getBytes();
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] thedigest = md.digest(bytesOfMessage);
		StringBuffer sb = new StringBuffer();
		for (byte b : thedigest) {
			sb.append(String.format("%02x", b & 0xff));
		}
		result= sb.toString();
		log.info("encoded pwd "+ result);
		}
		catch(Exception ex)
		{
			log.severe(ex.getMessage());
		}
		return result;
		
	}

}
