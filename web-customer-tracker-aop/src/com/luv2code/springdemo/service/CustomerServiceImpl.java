package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	// inject the DAO dependency
	@Autowired
	private CustomerDAO cusomerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return cusomerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		 cusomerDAO.saveCustomer(customer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int custId) {
		return cusomerDAO.getCustomer(custId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int custId) {
		cusomerDAO.deletCustomer(custId);
	}

	@Override
	@Transactional
	public List<Customer> searchCustomers(String custName) {
		return cusomerDAO.searchCustomers(custName);
	}

}
