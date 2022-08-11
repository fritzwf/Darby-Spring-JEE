package com.feuersoft.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.feuersoft.aopdemo.dao.AccountDAO;
import com.feuersoft.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

  public static void main(String[] args) {
    
    // read spring config java class
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(DemoConfig.class);
    
    // get the bean from spring container      Lower case here
    AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

    // get the bean from spring container            Lower case here
    MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);    
    
    // call the business method
    theAccountDAO.addAccount(new Account(), true);
    
    theAccountDAO.doAccountWork();
    
    theMembershipDAO.addAccount();
    
    theMembershipDAO.addTestAccount();
    
    // close the context
    context.close();
  }

}
