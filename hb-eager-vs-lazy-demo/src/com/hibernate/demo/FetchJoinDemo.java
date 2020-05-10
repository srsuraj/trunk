package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Student;

public class FetchJoinDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Instructor.class).
				addAnnotatedClass(InstructorDetail.class).
				addAnnotatedClass(Course.class).
				buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();

			// get the instructor from db
			int id = 1;
			
			Query<Instructor> query = session.createQuery("select i from Instructor i "
					+ "JOIN FETCH i.course "
					+ "where i.id=:instructorId", Instructor.class);
			
			// set parameter on query
			query.setParameter("instructorId", id);
			
			// execute query and get the instructor
			Instructor tempInstructor = 	query.getSingleResult();	
			
			System.out.println("Instructor is : " + tempInstructor);
			
			
			// commit the transaction
			session.getTransaction().commit();
			
			// close the session
			session.close();
			
			System.out.println("Session is Closed now");
			
			//print the courses
			for(Course course : tempInstructor.getCourse()) {
				System.out.println("courses of the instructor id 1 are : " + course);
			}
			
			System.out.println("Done!");
			
		} finally {
			session.close();
			factory.close();
		}

	}

}
