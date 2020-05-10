package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Student;

public class DeletedemoApp {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Instructor.class).
				addAnnotatedClass(InstructorDetail.class).
				buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();

			// get the instructor by primary key / id
			int instructorId = 1;
			Instructor instructor = session.get(Instructor.class, instructorId);
			
			// delete the instructor
			//
			// Note: it will also delete the InstructorDetail because
			// CascadeType.All
			if (instructor != null) {
				System.out.println("deleting the instructor with id" + instructor);
				session.delete(instructor);
			}
			
			// commit the transaction
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}

	}

}
