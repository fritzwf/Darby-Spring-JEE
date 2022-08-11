package com.feuersoft.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
  
  public void addAccount() {
    System.out.println(getClass().getSimpleName() + 
        ": MembershipDAO -> ADDING A NEW MEMBER\n");
  }
  
  public boolean addTestAccount() {
    System.out.println(getClass().getSimpleName() + 
        ": MembershipDAO -> CREATING A TEST ACCOUNT\n");
    return true;
  }  

}
