package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Student.class).
				buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			// create 3 Student object
			Student student = new Student("Suraj", "Singh", "srsuraj338@gmail.com");
			Student student1 = new Student("Ankit", "Singh", "ankit38@gmail.com");
			Student student2 = new Student("Abhi", "Sharma", "abhi.ccu@gmail.com");
			// start a transaction
			session.beginTransaction();
			// save Student Object to DB
			session.save(student);
			session.save(student1);
			session.save(student2);
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Students data saved is " + student);
		} finally {
			factory.close();
		}

	}

}
