package com.feuersoft.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {
  
  
  public String getFortune() {
    
    // simulate a delay
    try {
      TimeUnit.SECONDS.sleep(getRandomNumber(2, 6));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    
    // return a fortune
    return "Expect heavy traffic this morning.";
    
  }
  
  public long getRandomNumber(long min, long max) {
    return (long) ((Math.random() * (max - min)) + min);
  }

  public String getFortune(boolean tripWire) {
    
    if (tripWire) {
      throw new RuntimeException("Major accident, highway is closed!");
    }
    
    return getFortune();
  }

}
