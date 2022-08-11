package com.feuersoft.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.feuersoft.aopdemo.dao.AccountDAO;
import com.feuersoft.aopdemo.dao.MembershipDAO;
import com.feuersoft.aopdemo.service.TrafficFortuneService;
import java.util.logging.Logger;

public class AroundLoggerDemoApp {

  private static Logger myLogger = 
      Logger.getLogger(AroundLoggerDemoApp.class.getName());
  
  public static void main(String[] args) {
    
    // read spring config java class
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(DemoConfig.class);
    
    // get the bean from spring container       lower case!
    TrafficFortuneService theFortuneService = 
        context.getBean("trafficFortuneService", TrafficFortuneService.class);
    
    myLogger.info("\n\nMain Program: AroundDemoApp");
    
    myLogger.info("Calling getFortune");
    
    String data = theFortuneService.getFortune();
    
    myLogger.info("\nMy fortune is: " + data);
    
    myLogger.info("Finished");
    

    // close the context
    context.close();
  }

}
