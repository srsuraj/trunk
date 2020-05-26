package com.luv2code.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class CRMLoggingAspect {
	
	// setup logger
	private Logger logger = Logger.getLogger(getClass().getName());
	
	//setup pointcut declaration
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	private void forDAOPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
	private void forAppFlow() {}
	
	// add @Before Advice
	@Before("forAppFlow()")
	private void before(JoinPoint joinPoint) {
		
		// display the method we are calling
		String theMethod = joinPoint.getSignature().toShortString();
		logger.info("====>>> in @Before: calling method: " + theMethod);
		
		// display the argument of the method
		Object[] args = joinPoint.getArgs();
		for(Object obj : args) {
			logger.info("\n======>> argument: " + obj);
		}
		
	}
	
	// add @AfterReturning Advice
	@AfterReturning(pointcut="forAppFlow()", returning="result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		
		// display the method we are calling
		String theMethod = joinPoint.getSignature().toShortString();
		logger.info("====>>> in @AfterReturning: calling method: " + theMethod);
		
		// display the data returned
		logger.info("\n=======>>>> result: " + result);
		
	}

}
