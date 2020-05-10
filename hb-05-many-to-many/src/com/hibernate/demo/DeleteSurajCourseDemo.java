package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Review;
import com.hibernate.demo.entity.Student;

public class DeleteSurajCourseDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Instructor.class).
				addAnnotatedClass(InstructorDetail.class).
				addAnnotatedClass(Course.class).
				addAnnotatedClass(Review.class).
				addAnnotatedClass(Student.class).
				buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();

		   //  get Course from db
			int courseId = 10;
			Course theCourse = session.get(Course.class, courseId);
					
			System.out.println("\nLoaded Course from db.." + theCourse);
			
			// Delete the Course from DB
			System.out.println("\nDeleting Course from db...");
			session.delete(theCourse);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			session.close();
			factory.close();
		}

	}

}
