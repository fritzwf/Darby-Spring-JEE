package com.feuersoft.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.feuersoft.hibernate.demo.entity.Course;
import com.feuersoft.hibernate.demo.entity.Instructor;
import com.feuersoft.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

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
      
      // Get the instructor from DB
      long instId = 1;
      Instructor tmpInstructor = session.get(Instructor.class, instId);
      
      // Create some courses
      Course course1 = new Course("Golfing for Dummies");
      Course course2 = new Course("Kyaking for Dummies");
      
      // Add courses to instructor
      tmpInstructor.add(course1);
      tmpInstructor.add(course2);
      
      // Save courses
      session.save(course1);
      session.save(course2);
 
      System.out.println("Saved the new courses!");
      
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
