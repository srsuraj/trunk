package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Review;
import com.hibernate.demo.entity.Student;

public class AddCoursesForRichaDemo {

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

			//  create a course
			Course tempCourse = new Course("INT101");
			
			// save the course.
			System.out.println("\nSaving the course..");
			session.save(tempCourse);
			System.out.println("\nSaved the course.." + tempCourse);
			
			// create the students
			Student student1 = new Student("richa", "mad", "richa@gmail.com");
			Student student2 = new Student("suraj", "singh", "suraj@gmail.com");
			Student student3 = new Student("abhi", "sharma", "sharma@gmail.com");
			
			// add students to the course
			tempCourse.addStudent(student1);
			tempCourse.addStudent(student2);
			tempCourse.addStudent(student3);
			
			// save the students
			System.out.println("\nSaving the Students..");
			session.save(student1);
			session.save(student2);
			session.save(student3);
			System.out.println("\nSaved the students.." + tempCourse.getStudents());
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			session.close();
			factory.close();
		}

	}

}
