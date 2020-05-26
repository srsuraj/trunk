package com.spring.aopdemo.aspect;


import org.aspectj.lang.JoinPoint;
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
	
	// this is where we add all of our related advices for logging

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
