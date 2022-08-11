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

public class CreateCourseAndStudentsDemo {

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
      
      // Create some courses
      Course course1 = new Course("Golfing for Dummies");
      // Course course2 = new Course("Kyaking for Dummies");
      
      System.out.println("Saving the new course now...");

      // Save courses
      session.save(course1);
      //session.save(course2);
      
      System.out.println("Saved the course: " + course1);
      
      Student newStudent1 = null;
      Student newStudent2 = null;

      newStudent1 = new Student("Joey", "Bishop", "jbishop@palmsprings.com");
      newStudent2 = new Student("Dean", "Martin", "deano@palmsprings.com");
      
      course1.addStudent(newStudent1);
      course1.addStudent(newStudent2);
                 
      System.out.println("Creating new students!");   
      
      session.save(newStudent1);
      session.save(newStudent2);
      
      System.out.println("Saved students: " + course1.getStudents());
 
  
//      Course tmpCourse = new Course("Miner 2049er- How to finish the game.");
//      
//      tmpCourse.addReview(new Review("Excellent course!"));
//      tmpCourse.addReview(new Review("The best course I have ever taken!"));
//      tmpCourse.addReview(new Review("It was terrible, I couldn't finish the game!"));
          
      // SAVE TO THE DB
//      session.save(tmpCourse);
      
//      System.out.println("Saving tmpCourse: " + tmpCourse);
      
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
