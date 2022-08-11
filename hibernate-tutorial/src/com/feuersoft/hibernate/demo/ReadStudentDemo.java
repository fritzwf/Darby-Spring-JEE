package com.feuersoft.hibernate.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.feuersoft.hibernate.demo.entity.Student;

public class ReadStudentDemo {

  public static void main(String[] args) {
    
    // create session factory
    SessionFactory factory = 
      new Configuration().configure("hibernate.cfg.xml")
        .addAnnotatedClass(Student.class).buildSessionFactory();
    
    // create session
    Session session = factory.getCurrentSession();
    
    // Use the session object to save Java object
    try {
      // Create a student object
      System.out.println("Creating a new student!");
      Student newStudent = new Student("Peter", "Lawford", "peterl@palmspring.com", new Date());
      System.out.println(newStudent);

      // Start transaction
      session.beginTransaction();
      
      // Save the student object
      session.save(newStudent);
      System.out.println("Saved the new student entity!");
      
      // Commit transaction
      session.getTransaction().commit();
      
      System.out.println("Saved student.  Generated id: " + newStudent.getId());
      
      // Now get a new session and start transaction
      session = factory.getCurrentSession();
      session.beginTransaction();
      // Retrieve student based on the id: primary key
      System.out.println("\nGetting student with id: " + newStudent.getId());
      Student gotStudent = session.get(Student.class, newStudent.getId());
      System.out.println("Saved student.  Generated id: " + gotStudent);
      
      // Commit the transaction
      session.getTransaction().commit();
      
    } 
    finally {
      factory.close();
    }
    

  }

}
