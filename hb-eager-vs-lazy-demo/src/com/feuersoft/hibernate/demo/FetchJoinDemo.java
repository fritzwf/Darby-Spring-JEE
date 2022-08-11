package com.feuersoft.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.feuersoft.hibernate.demo.entity.Course;
import com.feuersoft.hibernate.demo.entity.Instructor;
import com.feuersoft.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

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
      
      Query<Instructor> query =
          session.createQuery(
              "select i from Instructor i "
              + "JOIN FETCH i.courses "
              + "where i.id=:theInstuctorId",
              Instructor.class);
      
      query.setParameter("theInstuctorId", instId);
      
      Instructor tmpInstructor = query.getSingleResult();

      System.out.println("FeuerSoft Instructor: " + tmpInstructor);

      System.out.println("FeuerSoft Courses: " + tmpInstructor.getCourses());
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
