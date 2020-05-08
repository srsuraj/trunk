package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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
			
			// delete the fetched student object
			session.delete(readstudent);
			
			// commit the transaction
			session.getTransaction().commit(); 
			
			// NEW CODE
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			// update the email for all student
			session.createQuery("delete from Student where id=2").executeUpdate(); // delete the student whose id =2
			
			session.getTransaction().commit();
			
			
		} finally {
			factory.close();
		}

	}

}
