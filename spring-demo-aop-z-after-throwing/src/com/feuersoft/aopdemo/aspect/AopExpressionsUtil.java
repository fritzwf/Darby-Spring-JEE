package com.feuersoft.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressionsUtil {

  // this is where we add all of our related advices for logging
  @Pointcut("execution(* com.feuersoft.aopdemo.dao.*.*(..))")
  public void forDaoPackage() {}  
  
  // create pointcut for getter methods
  @Pointcut("execution(* com.feuersoft.aopdemo.dao.*.get*(..))")
  public void getter() {}
  
  // create pointcut for setter methods
  @Pointcut("execution(* com.feuersoft.aopdemo.dao.*.set*(..))")
  public void setter() {}
  
  
  // create pointcut: include package ... exclude getter/setter
  @Pointcut("forDaoPackage() && !(getter() || setter())")
  public void forDaoPkgNoGetterSetter() {}
  
}
