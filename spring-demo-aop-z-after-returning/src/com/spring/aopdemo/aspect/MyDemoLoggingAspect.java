package com.spring.aopdemo.aspect;


import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
	
	// add anew advice for @AfterReturning on findAccounts method
	@AfterReturning(pointcut="execution(* com.spring.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
		
		// print out which method we are advicing on
		String method =joinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executing @AfterReturning on method: " + method);
		
		// print out the result of the method call
		System.out.println("\n=====>>> result is: " + result);
		
		// update or insert or delete the return value
		if (result!=null) {
			Account account = result.get(0);
			account.setName("Richa");
		}
		
	}

	@Before("com.spring.aopdemo.aspect.CustomAopExpression.allExceptGetterAndSetter()") // point cut declaration is used here as a point cut expression
	public void doBeforeAddAccount(JoinPoint theJoinPoint) {
		System.out.println("executing @Before advice on method");
		
		// display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Method: " + methodSig);
		
		// display the method arguments
		Object[] args = theJoinPoint.getArgs();
		
		// get args
		for (Object arg : args) {
			System.out.println(arg);
			
			if (arg instanceof Account) { {
				
				Account acc = (Account) arg;
				System.out.println("\nAccount name: " + acc.getName());
				System.out.println("Account level: " + acc.getLevel());
			}
				
			}
		}
		
		// loop through the args
	}
}
