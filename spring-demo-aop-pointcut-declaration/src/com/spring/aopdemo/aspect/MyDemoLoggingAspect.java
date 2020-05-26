package com.spring.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	// this is where we add all of our related advices for logging
	
	@Pointcut("execution(public * com.spring.aopdemo.dao.*.*(..))") // point cut declaration
	private void pointCutDeclaration() {}
	
	@Before("pointCutDeclaration()") // point cut declaration is used here as a point cut expression
	public void doBeforeAddAccount() {
		System.out.println("executing @Before advice on method");
	}
	
	@Before("pointCutDeclaration()") // point cut declaration is used here as a point cut expression
	public void performApiAnalyst() {
		System.out.println("Performing Api analyst");
	}

}
