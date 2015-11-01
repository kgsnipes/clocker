package com.clocker.aop;

import java.util.logging.Logger;

import org.apache.commons.codec.digest.DigestUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.clocker.dto.UserDTO;

@Component
@Aspect
public class UserAspect {
	
	private static final Logger log=Logger.getLogger(UserAspect.class.getName());
	
	@Around("execution(* *createUser(..))")
    public Object userPasswordEncryption(ProceedingJoinPoint pjp) throws Throwable {
        // start stopwatch
		
		log.info("performing the password encryption during creation of a user.");
		UserDTO user=(UserDTO)pjp.getArgs()[0];
		user.setPassword(new String(DigestUtils.sha512(user.getPassword())));
        return pjp.proceed(new Object[]{user});
    }

}
