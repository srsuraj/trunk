package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Student;

public class CreateCoursesDemo {

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
			Instructor tempInstructor = session.get(Instructor.class, id);
			
			// create some courses
			Course course1 = new Course("INT101");
			Course course2 = new Course("CSE100");
			Course course3 = new Course("CSE201");
			
			// add some courses
			tempInstructor.add(course1);
			tempInstructor.add(course2);
			tempInstructor.add(course3);
			
			// save the courses
			session.save(course1);
			session.save(course2);
			session.save(course3);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		} finally {
			session.close();
			factory.close();
		}

	}

}
