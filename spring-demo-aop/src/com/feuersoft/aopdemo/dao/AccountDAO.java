package com.feuersoft.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.feuersoft.aopdemo.Account;

@Component
public class AccountDAO {
  
//  public void addAccount() {
//    System.out.println(getClass() + 
//        ": DOING MY WORK: ADDING AN ACCOUNT");
//  }
  
  public void addAccount(Account theAccout, boolean vipFlag) {
    System.out.println(getClass() + 
        ": public void addAccount(Account theAccount)\n");
  }  

  public boolean doAccountWork() {
    System.out.println(getClass() + 
        ": public boolean doAccountWork()\n");
    return true;
  }    
  
  
}
