package com.feuersoft.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.feuersoft.aopdemo.dao.AccountDAO;
import com.feuersoft.aopdemo.dao.MembershipDAO;

public class AfterThrowingDemoApp {

  public static void main(String[] args) {
    
    // read spring config java class
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(DemoConfig.class);
    
    // get the bean from spring container       lower case!
    AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

    // call method to find the accounts
    List<Account> theAccounts = null; 
        
    try {
      // add a boolean flag to simulate exceptions
      boolean tripWire = true;
      theAccounts = theAccountDAO.findAccounts(tripWire); 
    }
    catch (Exception ex) {
      System.out.println("\n\nMain program ... caught exception: " + ex);
    }
    
    
    // display the accounts
    System.out.println("\n\nMain Program: AfterThrowingDemoApp");
    System.out.println("---------------------------------------");
    
    System.out.println(theAccounts);
    
    System.out.println("\n");
    
    // close the context
    context.close();
  }

}
