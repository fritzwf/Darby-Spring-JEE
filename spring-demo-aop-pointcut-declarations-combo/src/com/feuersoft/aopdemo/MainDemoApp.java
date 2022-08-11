package com.feuersoft.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.feuersoft.aopdemo.dao.AccountDAO;
import com.feuersoft.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

  public static void main(String[] args) {
    
    // read spring config java class
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(DemoConfig.class);
    
    // get the bean from spring container       lower case!
    AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

    // get the bean from spring container             lower case!
    MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);    
    
    Account myAccount = new Account();
    theAccountDAO.addAccount(myAccount, true);
    theAccountDAO.doAccountWork();
    
    // Set the account DAO setter's
    theAccountDAO.setName("Frik");
    theAccountDAO.setServiceCode("Frack");
    
    String name = theAccountDAO.getName();
    System.out.println("AccountDAO -> getName() -> " + name + "\n");
    String code = theAccountDAO.getServiceCode();
    System.out.println("AccountDAO getServiceCode() -> " + code +"\n");
    
    theAccountDAO.addAccount(myAccount, false);
    theAccountDAO.doAccountWork();
    
    theMembershipDAO.addAccount();
    theMembershipDAO.addTestAccount();
    
    // close the context
    context.close();
  }

}
