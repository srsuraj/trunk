package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Student;

public class DeleteInstructorDetailDemo {

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

			// get the instructor
			int id=3;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
					
			// delete the instructor detail and it will also delete instructor data
			// because of CascadeType.ALL
			System.out.println("deleting the instructor detail info : "+instructorDetail);
			//session.delete(instructorDetail);
			
			// remove the associated object reference
			// break bi-direction link
			instructorDetail.getInstructor().setInstructorDetail(null);
			session.delete(instructorDetail);
			
			// commit the transaction
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close(); // handle connection leak issue
			factory.close();
		}

	}

}
