package com.feuersoft.hibernate.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.feuersoft.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

  public static void main(String[] args) {
    
    // create session factory
    SessionFactory factory = 
      new Configuration().configure("hibernate.cfg.xml")
        .addAnnotatedClass(Student.class).buildSessionFactory();
    
    // create session
    Session session = factory.getCurrentSession();
    
    // Use the session object to save Java object
    try {
      // Create 3 student objects
      System.out.println("Creating a new student!");
      Student newStudent1 = new Student("Joey", "Bishop", "jbishop@palmspring.com", new Date());
      Student newStudent2 = new Student("Frank", "Sinatra", "frankcrooner@palmspring.com", new Date());
      Student newStudent3 = new Student("Sammy", "Davis", "sammyd@palmspring.com", new Date());

      // Start transaction
      session.beginTransaction();
      
      // Save the student object
      session.save(newStudent1);
      session.save(newStudent2);
      session.save(newStudent3);
      System.out.println("Saved the new student entity!");
      
      // Commit transaction
      session.getTransaction().commit();
      
      System.out.println("Committed the entity!");
      
    } 
    finally {
      factory.close();
    }
  }

}
