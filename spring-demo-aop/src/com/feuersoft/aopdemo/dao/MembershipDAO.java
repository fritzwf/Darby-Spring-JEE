package com.feuersoft.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
  
  public void addAccount() {
    System.out.println(getClass() + 
        ": MembershipDAO VOID\n");
  }
  
  public boolean addTestAccount() {
    System.out.println(getClass() + 
        ": MembershipDAO BOOLEAN\n");
    return true;
  }  

}
