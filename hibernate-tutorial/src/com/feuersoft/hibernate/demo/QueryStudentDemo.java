package com.feuersoft.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.feuersoft.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();
			
			// query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			// display the students
			Utils.displayStudents(theStudents);
			
			// query students: lastName='Davis'
			theStudents = session.createQuery("from Student s where s.lastName='Davis'").getResultList();
			
			// display the students
			System.out.println("\n\nStudents who have last name of Davis");
			Utils.displayStudents(theStudents);
			
			// query students: lastName='Martin' OR firstName='Dean'
			theStudents =
					session.createQuery("from Student s where"
							+ " s.lastName='Martin' OR s.firstName='Dean'").getResultList();
			
			System.out.println("\n\nStudents who have last name of Martin OR first name Dean");
			Utils.displayStudents(theStudents);
			
			// query students where email LIKE '%palmspring.com'
			theStudents = session.createQuery("from Student s where"
					+ " s.email LIKE '%palmspring.com'").getResultList();

			System.out.println("\n\nStudents whose email ends with palmspring.com");			
			Utils.displayStudents(theStudents);
			
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}