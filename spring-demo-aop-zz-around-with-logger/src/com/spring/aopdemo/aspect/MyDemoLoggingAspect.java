package com.spring.aopdemo.aspect;


import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.spring.aopdemo.Account;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	
	private Logger logger = Logger.getLogger(MyDemoLoggingAspect.class.getName());
	
	// add new advice for @After on findAccounts method
	@Around("execution(* getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint joinPoint) throws Throwable {
		
		// print out which method we are advising on
		String method = joinPoint.getSignature().toShortString();
		logger.info("\n=====>>> Executing @Around on method: " + method);
		
		// get begin timestamp
		long begin = System.currentTimeMillis();
		
		// noe exceute the method
		Object result = joinPoint.proceed();
		
		// get end timestamp
		long end = System.currentTimeMillis();
		
		// compute duration and display
		long duration = end-begin;
		logger.info("\n=====>>>> Duration: " + duration/1000.0 + " seconds");
		
		return result;
	}
	
	
	
	@After("execution(* com.spring.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountAdvice(JoinPoint joinPoint) {
		
		// print out which method we are advising on
		String method =joinPoint.getSignature().toShortString();
		logger.info("\n=====>>> Executing @After (finally) on method: " + method);
	}
	
	@AfterThrowing(pointcut="execution(* com.spring.aopdemo.dao.AccountDAO.findAccounts(..))", throwing="exe")
	public void afterThrowingFindAccountAdvice(JoinPoint joinPoint, Throwable exe) {
		
		// print out which method we are advising on
		String method =joinPoint.getSignature().toShortString();
		logger.info("\n=====>>> Executing @AfterThrowing on method: " + method);
		
		// log the exception
		logger.info("\n=====>>> the Exception is: " + exe);
		
	}
	
	@AfterReturning(pointcut="execution(* com.spring.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
		
		// print out which method we are advicing on
		String method =joinPoint.getSignature().toShortString();
		logger.info("\n=====>>> Executing @AfterReturning on method: " + method);
		
		// print out the result of the method call
		logger.info("\n=====>>> result is: " + result);
		
		// update or insert or delete the return value
		if (result!=null) {
			Account account = result.get(0);
			account.setName("Richa");
		}
		
	}

	@Before("com.spring.aopdemo.aspect.CustomAopExpression.allExceptGetterAndSetter()") // point cut declaration is used here as a point cut expression
	public void doBeforeAddAccount(JoinPoint theJoinPoint) {
		logger.info("executing @Before advice on method");
		
		// display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		logger.info("Method: " + methodSig);
		
		// display the method arguments
		Object[] args = theJoinPoint.getArgs();
		
		// get args
		for (Object arg : args) {
			logger.info(arg.toString());
			
			if (arg instanceof Account) { {
				
				Account acc = (Account) arg;
				logger.info("\nAccount name: " + acc.getName());
				logger.info("Account level: " + acc.getLevel());
			}
				
			}
		}
		
		// loop through the args
	}
}
