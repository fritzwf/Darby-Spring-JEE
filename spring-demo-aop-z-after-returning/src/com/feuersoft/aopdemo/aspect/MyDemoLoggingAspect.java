package com.feuersoft.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.feuersoft.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
  
  
  // add a new advice for @AfterReturning on the findAccounts method
  @AfterReturning(
   pointcut="execution(* com.feuersoft.aopdemo.dao.AccountDAO.findAccounts(..))",
   returning="result"
  )
  public void afterReturningFindAccountAdvice(
                JoinPoint theJoinPoint, List<Account> result) {
    
    // print out which method we are advising on
    String method = theJoinPoint.getSignature().toShortString();
    System.out.println(getClass().getSimpleName() + 
        " =====>>> Executing @AfterReturning on method: " + method);
    
    // print out the results of the method call
    System.out.println(getClass().getSimpleName() + 
        " =====>>> Result is: " + result);
    
    // let's post-process the data ... let's modify it
    
    // convert the account names to uppercase
    convertAccountNamesToUpperCase(result);
    
    System.out.println(getClass().getSimpleName() + 
        " =====>>> Result (Modified) is: " + result);
    
  }
  
  private void convertAccountNamesToUpperCase(List<Account> result) {
    
    // loop through accounts
    for (Account tmpAcct : result) {
      
      // get uppercase version of name
      String theUpperCaseName = tmpAcct.getName().toUpperCase();
      
      // update the name on the account
      tmpAcct.setName(theUpperCaseName);
    }
    
  }




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
  @Before("com.feuersoft.aopdemo.aspect.AopExpressionsUtil.forDaoPkgNoGetterSetter()")
  public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
    
    System.out.println(getClass().getSimpleName() + 
        " =======>>> Executing forDaoPkgNoGetterSetter()");
    
    // display the signature
    MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
    System.out.println(getClass().getSimpleName() + 
        " Method signiture -> " + methodSig);
    
    
    // display method arguments
    
    // get the args array
    Object[] args = theJoinPoint.getArgs();
    
    // iterate through the args
    for (Object tmpArg : args) {
      
      // downcast and print Account specific stuff.
      if (tmpArg instanceof Account) {
        Account theAccount = (Account) tmpArg;
        System.out.println("VAR -> Level: " + theAccount.getLevel() +
           ", Name: " + theAccount.getName());
      } else {
        System.out.println("VAR -> " + tmpArg);
      }
    }

  }
  
}
