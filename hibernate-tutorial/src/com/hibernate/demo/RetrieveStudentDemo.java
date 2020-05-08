package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class RetrieveStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Student.class).
				buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			// create Student object
			Student student = new Student("Dough", "braun", "daug@gmail.com");
			// start a transaction
			session.beginTransaction();
			// save Student Object to DB
			session.save(student);
			System.out.println("Student data saved is " + student);
			// commit the transaction
			session.getTransaction().commit();
			
			// Find out the student's id: primaryKey
			System.out.println("saved student. Generated id is: " + student.getId());
			
			// now get the session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve the student based on the id: primary key
			System.out.println("Retrieving Student with id: " + student.getId());
			
			Student readstudent = session.get(Student.class, student.getId());
			
			System.out.println("Student data retrieved is " + readstudent);
			
			//commit the transaction
			session.getTransaction().commit();
			
			
		} finally {
			factory.close();
		}

	}

}
