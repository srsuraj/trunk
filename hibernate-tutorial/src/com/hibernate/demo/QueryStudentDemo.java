package com.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Student.class).
				buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();
			
			// query students
			List<Student> studentLst = session.createQuery("from Student").getResultList();
			
			// display the students
			displayStudent(studentLst);
			System.out.println("\n");
			
			// query student with last name as singh
			studentLst = session.createQuery("from Student s where s.lastName='singh'").list();
			
			// display the students
			displayStudent(studentLst);
			System.out.println("\n");
			
			// query student with last name as singh or firstname as abhi
			studentLst = session.createQuery("from Student s where s.lastName='singh' OR s.firstName='abhi'").list();
						
			// display the students
			displayStudent(studentLst);
			System.out.println("\n");
			
			// query student email whose email contains 8
			studentLst = session.createQuery("from Student s where s.email like '%8%'").list();
									
			// display the students
			displayStudent(studentLst);
			
			// commit the transaction
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}

	}

	public static void displayStudent(List<Student> studentLst) {
		for(Student student : studentLst) {
			System.out.println(student);
		}
	}

}
