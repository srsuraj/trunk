package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Student;

public class CreateDemoApp {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Instructor.class).
				addAnnotatedClass(InstructorDetail.class).
				buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			// create the objects
			Instructor instructor = new Instructor("richa", "mad", "richa@gmail.com");
			
			InstructorDetail instructorDetail = new InstructorDetail("https://youtube.com/richa", "sleeping");
			
			// associate the objects
			instructor.setInstructorDetail(instructorDetail);
			
			// start a transaction
			session.beginTransaction();

			// save the instructor
			//
			//Note: this will also save the details object 
			// because of CascadeType.ALL
			//
			System.out.println("saving the instrutor: " + instructor);
			session.save(instructor);
			
			// commit the transaction
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}

	}

}
