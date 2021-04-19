package com.banking.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.banking.entities.Customer;
import com.banking.repositories.CustomerRepository;

@Service
public class CustomerService {

	private Customer customer;
	private CustomerRepository repo;
	
	public CustomerService(Customer customer, CustomerRepository repo) {
		this.customer = customer;
		this.repo = repo;
	}
	
	////////////////////////////////////////////////////////////////////////////////
	public List<Customer> findAll(){
		return repo.findAll();
	}
	
	////////////////////////////////////////////////////////////////////////////////
	public Customer findById(int id) {
		return repo.findById(id);
	}
	///////////////////////////////////////////////////////////////////////////////
	public void save(Customer customer) {
		repo.saveAndFlush(customer);
	}

}
