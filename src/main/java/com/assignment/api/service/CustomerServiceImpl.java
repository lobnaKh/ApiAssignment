package com.assignment.api.service;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assignment.api.entities.Customer;
import com.assignment.api.repositories.CustomerRepository;

@Service("customerService")
@Transactional
public class CustomerServiceImpl extends BaseServiceImpl<Customer, Serializable> implements CustomerService{

	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Optional<Customer> findById(int id) {
		return customerRepository.findById(id);
	}

}
