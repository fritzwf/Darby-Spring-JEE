package com.feuersoft.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.feuersoft.hibernate.demo.entity.Instructor;
import com.feuersoft.hibernate.demo.entity.InstructorDetail;
import com.feuersoft.hibernate.demo.entity.Student;

public class DeleteInstructorDetailDemo {

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
      
      // Start transaction
      session.beginTransaction();
      
      long instDetailId = 3;
      
      // Get instructor detail object
      // Get the the object from the database.
      InstructorDetail instDetail = session.get(InstructorDetail.class, instDetailId); 
      
      // Print the instructor detail
      System.out.println("INSTRUCTOR DETAIL: " + instDetail);
      
      // Print the associated instructor 
      System.out.println("INSTRUCTOR: " + (null != instDetail ? instDetail.getInstructor() : "INSTRUCTOR NOT FOUND"));
      
      // Print the instructor detail ID 
      System.out.println("DELETING THE INSTRUCTOR DETAILS ID: " + instDetail.getId());
      
      // Remove the associated object reference to break the bi-directional link.
      instDetail.getInstructor().setInstructorDetail(null);
      
      // Delete the instructor detail
      session.delete(instDetail);
      
      // Commit transaction
      session.getTransaction().commit();
      
      System.out.println("Done!");
      
    } finally {
      session.close();
      factory.close();
    }
    

  }

}
