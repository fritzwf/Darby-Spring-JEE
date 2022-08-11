package com.feuersoft.hibernate.demo;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.feuersoft.hibernate.demo.entity.Course;
import com.feuersoft.hibernate.demo.entity.Instructor;
import com.feuersoft.hibernate.demo.entity.InstructorDetail;
import com.feuersoft.hibernate.demo.entity.Review;
import com.feuersoft.hibernate.demo.entity.Student;

public class GetCoursesForDeanoDemo {

  public static void main(String[] args) {
    
    // create session factory
    SessionFactory factory = 
      new Configuration().configure("hibernate.cfg.xml")
        .addAnnotatedClass(Instructor.class)
        .addAnnotatedClass(InstructorDetail.class)
        .addAnnotatedClass(Course.class)
        .addAnnotatedClass(Review.class)
        .addAnnotatedClass(Student.class)
        .buildSessionFactory();
    
    // create session
    Session session = factory.getCurrentSession();
    
    try {
      // Create the objects
      
      // Start transaction
      session.beginTransaction();
      
      long deanoId = 6;
      
      Student deanoStudent = session.get(Student.class, deanoId);
      System.out.println("Loaded student: " + deanoStudent);
      System.out.println("Deano's courses: " + deanoStudent.getCourses());
      
      System.out.println("Done!!!!!");
      
      // Commit transaction
      session.getTransaction().commit();
 
    }  
    finally {
      // Clean up
      session.close();
      factory.close();
    }
    

  }

}
