package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Student.class).
				buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 1;
			
			// start a transaction
			session.beginTransaction();
			
			// get the student data from db where student id is 1
			Student readstudent = session.get(Student.class, studentId);
			
			//display the fetched student data
			System.out.println("Fetched student data is: "+readstudent);
			
			// set the first name of the student using student object
			readstudent.setFirstName("mady");
			
			// commit the transaction
			session.getTransaction().commit(); // this will update the student with new first name "mady" for id 1
			
			// NEW CODE
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			// update the email for all student
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			
			session.getTransaction().commit();
			
			
		} finally {
			factory.close();
		}

	}

}
