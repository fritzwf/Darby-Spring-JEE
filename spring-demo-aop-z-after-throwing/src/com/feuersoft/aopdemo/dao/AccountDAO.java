package com.feuersoft.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.feuersoft.aopdemo.Account;

@Component
public class AccountDAO {
  
  private String name;
  private String serviceCode;
  
  // Add a new method: findAccounts()
  public List<Account> findAccounts(boolean tripWire) {
    
    List<Account> myAccounts = new ArrayList<>();
    
    // create sample accounts
    Account tmp1 = new Account("Dean", "Silver");
    Account tmp2 = new Account("Frank", "Platinum");
    Account tmp3 = new Account("Sammy", "Gold");
    
    // add them to our accounts list
    myAccounts.add(tmp1);
    myAccounts.add(tmp2);
    myAccounts.add(tmp3);
    
    if (tripWire) {
      throw new RuntimeException("No soup for you!!!");
    }
    
    return myAccounts;
    
  }
  
  public void addAccount(Account theAccout, boolean vipFlag) {
    System.out.println(getClass().getSimpleName() +
        " ADDING -> A NEW SYSTEM ACCOUNT\n");
  }  

  public boolean doAccountWork() {
    System.out.println(getClass().getSimpleName() + 
        " AUDITING -> ALL ACCOUNTS\n");
    return true;
  }

  public String getName() {
    System.out.println(getClass().getSimpleName() + " getName()\n");
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
