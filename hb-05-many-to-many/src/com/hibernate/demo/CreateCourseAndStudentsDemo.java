package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Review;
import com.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

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

			//  get student richa from db
			int studentId = 1;
			Student theStudent = session.get(Student.class, studentId);
			
			System.out.println("\nLoaded Student from db.." + theStudent);
			System.out.println("\nCourses for student.." + theStudent.getCourses());

			// create more courses
			Course course1 = new Course("CSE101");
			Course course2 = new Course("CSE201");
			
			// add student to the courses
			System.out.println("\nAdding student to the courses...");
			course1.addStudent(theStudent);
			course2.addStudent(theStudent);
			
			// save the courses
			System.out.println("\nSaving the courses...");
			session.save(course1);
			session.save(course2);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			session.close();
			factory.close();
		}

	}

}
