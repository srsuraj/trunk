package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		// crate a query.... sort by last name
		Query<Customer> theQuery = session.createQuery("from Customer order by lastName", Customer.class);
		
		// execute query and get the result list
		List<Customer> customers = theQuery.getResultList();
		
		// return the result
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {

		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		// save/update the customer
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int custId) {

		Session session = sessionFactory.getCurrentSession();
		
		return session.get(Customer.class, custId);
	}

	@Override
	public void deletCustomer(int custId) {

		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", custId);
		query.executeUpdate();
	}

	@Override
	public List<Customer> searchCustomers(String custName) {

		Session session = sessionFactory.getCurrentSession();
		Query query;
		custName = custName.trim();
		if (custName!=null && custName.length()>0) {
			query = session.createQuery("from Customer where lower(firstName) like :custName or lower(lastName) like :custName");
			query.setParameter("custName", "%" +custName+ "%");
		} else {
			query = session.createQuery("from Customer");
		}
		return query.getResultList();
	}

}
