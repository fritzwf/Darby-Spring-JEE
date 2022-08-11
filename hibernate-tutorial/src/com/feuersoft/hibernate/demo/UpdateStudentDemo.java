package com.feuersoft.hibernate.demo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.feuersoft.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	 public static void main(String[] args) {

 	// create session factory
 	SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
 		
		// create session
		Session session = factory.getCurrentSession();
		
		try {								
 			long studentId = 4;
 			
 			// now get a new session and start transaction
 			session = factory.getCurrentSession();
 			session.beginTransaction();
 			
 			// retrieve student based on the id: primary key
 			System.out.println("\nGetting student with id: " + studentId);
 			
 			Student myStudent = session.get(Student.class, studentId);
 			
 			System.out.println("Updating student...");
// 			myStudent.setFirstName("Tony");
// 			myStudent.setLastName("Rome");
 			
 			try {
      myStudent.setDateOfBirth(Utils.parseDate("12/12/1915"));
    } catch (ParseException e) {
      e.printStackTrace();
    } 			
 			
 			System.out.println(myStudent);
 			
 			// commit the transaction
 			session.getTransaction().commit();
 
 			// NEW CODE
 	/*		
 			
 			session = factory.getCurrentSession();
 			session.beginTransaction();
 			
 			// update email for all students
 			System.out.println("Update email for all students");
 			
    session.createQuery("update Student s set s.email='tony.rome@gmail.com' where s.lastName='Rome'")
      .executeUpdate();      
    
 			// commit the transaction
 			session.getTransaction().commit();
 */
 			System.out.println("Done!");
 		}
 		finally {
 		  factory.close();
 		}
 }
}





