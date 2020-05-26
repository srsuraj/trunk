package com.spring.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomAopExpression {
	
	// this is where we add all of our related advices for logging
	
	@Pointcut("execution(public * com.spring.aopdemo.dao.*.*(..))") // point cut declaration
	public void pointCutDeclaration() {}
	
	// create pointcut for getter methods
	@Pointcut("execution(public * com.spring.aopdemo.dao.*.get*(..))") // point cut declaration
	public void getterPointCutDeclaration() {}
	
	// create pointcut for setter methods
	@Pointcut("execution(public * com.spring.aopdemo.dao.*.set*(..))") // point cut declaration
	public void setterPointCutDeclaration() {}
	
	// create pointcut: include package exclude getter and setter methods
	@Pointcut("pointCutDeclaration() && !(getterPointCutDeclaration() || setterPointCutDeclaration())")
	public void allExceptGetterAndSetter() {}
	
}
