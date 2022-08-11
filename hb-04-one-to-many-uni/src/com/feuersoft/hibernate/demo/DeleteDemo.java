package com.feuersoft.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.feuersoft.hibernate.demo.entity.Instructor;
import com.feuersoft.hibernate.demo.entity.InstructorDetail;
import com.feuersoft.hibernate.demo.entity.Student;

public class DeleteDemo {

  public static void main(String[] args) {
    
    // create session factory
    SessionFactory factory = 
      new Configuration().configure("hibernate.cfg.xml")
        .addAnnotatedClass(Instructor.class)
        .addAnnotatedClass(InstructorDetail.class)
        .buildSessionFactory();
    
    // create session
    Session session = factory.getCurrentSession();
    
    // Use the session object to save Java object
    try {
      
      long instructorId = 2;
      
      // Start transaction
      session.beginTransaction();
      
      // Get the the object from the database.
      Instructor myInstructor = session.get(Instructor.class, instructorId);      
      
      if (null != myInstructor) {
        System.out.println("Attemtping to delete the instructor: " + myInstructor);
        // The delete will also delete the InstructorDetails as well.
        session.delete(myInstructor);
      } else {
        System.out.println("Instructor was not retrieved!");
      }
      
      System.out.println("deleted the instructor entity!");
      
      // Commit transaction
      session.getTransaction().commit();
      
      System.out.println("Committed the entity!");
      
    } 
    finally {
      factory.close();
    }
    

  }

}
