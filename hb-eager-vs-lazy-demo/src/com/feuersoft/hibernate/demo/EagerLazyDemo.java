package com.feuersoft.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.feuersoft.hibernate.demo.entity.Course;
import com.feuersoft.hibernate.demo.entity.Instructor;
import com.feuersoft.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

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
      
      // Start transaction
      session.beginTransaction();
      
      // Get the instructor from DB
      long instId = 1;
      Instructor tmpInstructor = session.get(Instructor.class, instId);
      
      System.out.println("FeuerSoft Instructor: " + tmpInstructor);

      
      // Get instructor courses
      System.out.println("FeuerSoft Courses: " + tmpInstructor.getCourses());
      
 
      System.out.println("Saved the new courses!");
      
      // Commit transaction
      session.getTransaction().commit();
      
      System.out.println("FeuerSoft committed the entity!");
      
    } 
    finally {
      // Clean up
      session.close();
      factory.close();
    }
    

  }

}
