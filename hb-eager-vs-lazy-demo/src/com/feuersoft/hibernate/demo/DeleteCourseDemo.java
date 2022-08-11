package com.feuersoft.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.feuersoft.hibernate.demo.entity.Course;
import com.feuersoft.hibernate.demo.entity.Instructor;
import com.feuersoft.hibernate.demo.entity.InstructorDetail;

public class DeleteCourseDemo {

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
    
    try {
      // Create the objects
      
      // Associate the objects
//      tmpInstructor.setInstructorDetail(tmpInstructorDetails);

      // Start transaction
      session.beginTransaction();
      
      // Get the course we want to delete from DB
      long instId = 10;
      
      // Get the course
      Course tmpCourse = session.get(Course.class, instId);
      
      // Delete the course
      System.out.println("Deleting course: " + tmpCourse);
      
      session.delete(tmpCourse);
      
      
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
