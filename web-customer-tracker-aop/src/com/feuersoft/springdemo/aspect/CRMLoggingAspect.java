package com.feuersoft.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

  // setup logger
  private Logger myLogger = 
      Logger.getLogger(getClass().getName());
  
  // ======> setup Pointcut declarations <======
  
  // execution package for any method and any input parameters
  @Pointcut("execution(* com.feuersoft.springdemo.controller.*.*(..))")
  private void forControllerPackage() {}
  
  // execution package for any method and any input parameters
  @Pointcut("execution(* com.feuersoft.springdemo.service.*.*(..))")
  private void forServicerPackage() {}  
  
  // execution package for any method and any input parameters
  @Pointcut("execution(* com.feuersoft.springdemo.dao.*.*(..))")
  private void forDaoPackage() {}
  
  // Combination of all pointcut's above
  @Pointcut("forControllerPackage() || forServicerPackage() || forDaoPackage()")
  private void forAppFlow() {}
  
  // add @Before advice
  @Before("forAppFlow()")
  public void before(JoinPoint theJoinPoint) {
    
    // display method we are calling
    String theMethod = theJoinPoint.getSignature().toShortString();
    myLogger.info("=====> in @Before: calling method: " + theMethod);
    
    // display the arguments to the method
    
    // get the arguments
    Object[] args = theJoinPoint.getArgs();
    for (Object tmpArg : args) {
      myLogger.info("-------> argument: " + tmpArg);
    }
  }
  
  // add @AfterReturning advice
  @AfterReturning(
    pointcut="forAppFlow()",
    returning="theResult"
  )
  public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
    
    // display method we are returning from
    String theMethod = theJoinPoint.getSignature().toShortString();
    myLogger.info("=====> in @AfterReturning: from method: " + theMethod);
    
    // display data returned
    myLogger.info("====>> result: " + theResult);
  }
  
  
}
