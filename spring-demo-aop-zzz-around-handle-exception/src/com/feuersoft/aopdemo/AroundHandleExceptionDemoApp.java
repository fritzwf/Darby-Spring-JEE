package com.feuersoft.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.feuersoft.aopdemo.service.TrafficFortuneService;
import java.util.logging.Logger;

public class AroundHandleExceptionDemoApp {

  private static Logger myLogger = 
      Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());
  
  public static void main(String[] args) {
    
    // read spring config java class
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(DemoConfig.class);
    
    // get the bean from spring container       lower case!
    TrafficFortuneService theFortuneService = 
        context.getBean("trafficFortuneService", TrafficFortuneService.class);
    
    myLogger.info("\n\nMain Program: AroundDemoApp");
    
    myLogger.info("Calling getFortune");
    
    // add a boolean flag to simulate exceptions
    boolean tripWire = true;
    
    String data = theFortuneService.getFortune(tripWire);
    
    myLogger.info("\nMy fortune is: " + data);
    
    myLogger.info("Finished");
    

    // close the context
    context.close();
  }

}
