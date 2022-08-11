package com.feuersoft.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.feuersoft.aopdemo.Account;

@Component
public class AccountDAO {
  
  private String name;
  private String serviceCode;
  
  public void addAccount(Account theAccout, boolean vipFlag) {
    System.out.println(getClass() + 
        " ADDING -> A NEW SYSTEM ACCOUNT\n");
  }  

  public boolean doAccountWork() {
    System.out.println(getClass() + 
        " AUDITING -> ALL ACCOUNTS\n");
    return true;
  }

  public String getName() {
    System.out.println(getClass() + " getName()\n");
    return name;
  }

  public void setName(String name) {
    System.out.println(getClass() + " setName()\n");
    this.name = name;
  }

  public String getServiceCode() {
    System.out.println(getClass() + " getServiceCode()\n");
    return serviceCode;
  }

  public void setServiceCode(String serviceCode) {
    System.out.println(getClass() + " setServiceCode()\n");
    this.serviceCode = serviceCode;
  }
  
}
