package com.spring.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyDemoCloudAsyncAspect {
	
	// this is where we add all of our related advices for logging
	
	@Before("com.spring.aopdemo.aspect.CustomAopExpression.allExceptGetterAndSetter()") // point cut declaration is used here as a point cut expression
	public void logToCloudAsync() {
		System.out.println("Logging to cloud in async fashion");
	}
}
