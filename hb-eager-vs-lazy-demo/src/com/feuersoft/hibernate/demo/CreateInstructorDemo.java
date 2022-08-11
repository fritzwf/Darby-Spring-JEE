package com.feuersoft.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.feuersoft.hibernate.demo.entity.Course;
import com.feuersoft.hibernate.demo.entity.Instructor;
import com.feuersoft.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

  public static void main(String[] args) {
    
    // create session factory
    SessionFactory factory = 
      new Configuration().configure("hibernate.cfg.xml")
        .addAnnotatedClass(Instructor.class)
        .addAnnotatedClass(InstructorDetail.class)
        .addAnnotatedClass(Course.class)
        .buildSessionFactory();
    
    // create session
    Session session = factory.getCurrentSession();
    
    // Use the session object to save Java object
    try {
      // Create the objects
      
//      Instructor tmpInstructor = new Instructor("Fritz", "FeuerSoft", "support@feuersoft.com");
//      InstructorDetail tmpInstructorDetails = new InstructorDetail("CodeMonkees", "Coding all the time!");

      Instructor tmpInstructor = new Instructor("Austin", "Powers", "shagadellic@gmail.com");
      InstructorDetail tmpInstructorDetails = new InstructorDetail("International Man of Mystery", "Shag");      
      
      // Associate the objects
      tmpInstructor.setInstructorDetail(tmpInstructorDetails);
      
      // Start transaction
      session.beginTransaction();
      
      // Save the student object
      if (null != tmpInstructor) {
        System.out.println("Instructor entity before save: " + tmpInstructor);
        session.save(tmpInstructor);
      }
      System.out.println("Saved the new instructor entity!");
      
      // Commit transaction
      session.getTransaction().commit();
      
      System.out.println("Committed the entity!");
      
    } 
    finally {
      // Clean up
      session.close();
      factory.close();
    }
    

  }

}
