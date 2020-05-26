package com.spring.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	
	// this is where we add all of our related advices for logging

	@Before("com.spring.aopdemo.aspect.CustomAopExpression.allExceptGetterAndSetter()") // point cut declaration is used here as a point cut expression
	public void doBeforeAddAccount() {
		System.out.println("executing @Before advice on method");
	}
}
