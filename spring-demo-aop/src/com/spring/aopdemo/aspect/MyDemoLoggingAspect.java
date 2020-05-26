package com.spring.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	// this is where we add all of our related advices for logging
	
	//@Before("execution(* add*(com.spring.aopdemo.Account))") // for method with param type Account
	//@Before("execution(public void add*())") // these are point cut expression "execution(public void addAccount())"
	//@Before("execution(public * add*(..))") // for add* maethod with zero or more param
	@Before("execution(public * com.spring.aopdemo.dao.*.*(..))") // for any class in com.spring.aopdemo.dao package and in any method with any no of param
	public void doBeforeAddAccount() {
		
		System.out.println("executing @Before advice on method");
	}

}
