package com.feuersoft.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.feuersoft.aopdemo.dao.AccountDAO;
import com.feuersoft.aopdemo.dao.MembershipDAO;
import com.feuersoft.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

  public static void main(String[] args) {
    
    // read spring config java class
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(DemoConfig.class);
    
    // get the bean from spring container       lower case!
    TrafficFortuneService theFortuneService = 
        context.getBean("trafficFortuneService", TrafficFortuneService.class);
    
    System.out.println("\n\nMain Program: AroundDemoApp");
    
    System.out.println("Calling getFortune");
    
    String data = theFortuneService.getFortune();
    
    System.out.println("\nMy fortune is: " + data);
    
    System.out.println("Finished");
    

    // close the context
    context.close();
  }

}
