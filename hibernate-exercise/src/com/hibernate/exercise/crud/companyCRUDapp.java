package com.hibernate.exercise.crud;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.exercise.entity.Company;

public class companyCRUDapp {

	static SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Company.class).buildSessionFactory();
	
	public void create() {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Company company = new Company("richa", "mad", "Cap");
		Company company1 = new Company("abhi", "sharma", "tcs");
		Company company2 = new Company("subbu", "yadav", "kony");
		session.save(company);
		session.save(company1);
		session.save(company2);
		session.getTransaction().commit();
	}
	
	public void update() {
		List<Company> companyLst = new ArrayList<>();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		companyLst= session.createQuery("from Company where company='blujay'").list();
		Company company = companyLst.get(0);
		company.setFirstName("mady");
		session.getTransaction().commit();
		//
		session = factory.getCurrentSession();
		session.beginTransaction();
		session.createQuery("update Company set company='arcesium' where id=1").executeUpdate();
		session.getTransaction().commit();
	}
	
	public void delete() {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.createQuery("delete from Company where id=1").executeUpdate();
		session.getTransaction().commit();
		//
		session = factory.getCurrentSession();
		session.beginTransaction();
		Company company = session.get(Company.class, 2);
		session.delete(company);
		session.getTransaction().commit();
	}
	
	public List<Company> fetch() {
		List<Company> companyLst = new ArrayList<>();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		companyLst= session.createQuery("from Company where company='blujay'").list();
		//Company company = session.get(Company.class, 1);
		//companyLst.add(company);		
		session.getTransaction().commit();
		return companyLst;
	}
	
	
	public static void main(String[] args) {
		try {
		companyCRUDapp app = new companyCRUDapp();
		//app.create();
//		for(Company company : app.fetch()) {
//			System.out.println(company);
//		}
		//app.update();
		app.delete();
		} finally {
			factory.close();
		}
	}
	
}
