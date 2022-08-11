package com.feuersoft.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.feuersoft.hibernate.demo.entity.Student;

public class CreateStudentDemo {

  public static void main(String[] args) {
    
    // create session factory
    SessionFactory factory = 
      new Configuration().configure("hibernate.cfg.xml")
        .addAnnotatedClass(Student.class).buildSessionFactory();
    
    // create session
    Session session = factory.getCurrentSession();
    
    Student newStudent = null;
    // Use the session object to save Java object
    try {
      // Create a student object
      System.out.println("Creating a new student!");
      try {
        newStudent = new Student("Joey", "Bishop", "jbishop@palmsprings.com", Utils.parseDate("02/03/1918"));
      } catch (ParseException e) {
        e.printStackTrace();
      }         
      
      // Start transaction
      session.beginTransaction();
      
      // Save the student object
      if (null != newStudent) {
        session.save(newStudent);
      }
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
