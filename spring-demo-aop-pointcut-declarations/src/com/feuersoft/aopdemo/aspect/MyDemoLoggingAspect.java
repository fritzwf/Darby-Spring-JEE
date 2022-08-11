package com.feuersoft.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
  
  // this is where we add all of our related advices for logging
  @Pointcut("execution(* com.feuersoft.aopdemo.dao.*.*(..))")
  public void forDaoPackage() {}  
  
  // let's start with an @Before advice
  // @Before("execution(public void addAccount())")
  // @Before("execution(* addAccount())")
  // @Before("execution(public void com.feuersoft.aopdemo.dao.AccountDAO.addAccount())")
  // @Before("execution(public void add*())")
  // @Before("execution(void add*())")
  // @Before("execution(* add*(com.feuersoft.aopdemo.Account))")
  // @Before("execution(* add*(com.feuersoft.aopdemo.Account, ..))")
  // @Before("execution(* add*(..))")
  // @Before("execution(* com.feuersoft.aopdemo.dao.*.*(..))")
  @Before("forDaoPackage()")
  public void beforeAddAccountAdvice() {
    System.out.println( 
        "=======>>> Executing @Before advice on com.feuersoft.aopdemo.dao.*.*(..)");
  }
  
  
  public void performApiAnalytics() {
    System.out.println( 
        "=======>>> Performing API Analytics ");
  }
  
  
  
}
