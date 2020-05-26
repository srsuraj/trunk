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
	
	// create pointcut for getter methods
	@Pointcut("execution(public * com.spring.aopdemo.dao.*.get*(..))") // point cut declaration
	private void getterPointCutDeclaration() {}
	
	// create pointcut for setter methods
	@Pointcut("execution(public * com.spring.aopdemo.dao.*.set*(..))") // point cut declaration
	private void setterPointCutDeclaration() {}
	
	// create pointcut: include package exclude getter and setter methods
	@Pointcut("pointCutDeclaration() && !(getterPointCutDeclaration() || setterPointCutDeclaration())")
	private void allExceptGetterAndSetter() {}
	
	@Before("allExceptGetterAndSetter()") // point cut declaration is used here as a point cut expression
	public void doBeforeAddAccount() {
		System.out.println("executing @Before advice on method");
	}
	
	@Before("allExceptGetterAndSetter()") // point cut declaration is used here as a point cut expression
	public void performApiAnalyst() {
		System.out.println("Performing Api analyst");
	}

}
