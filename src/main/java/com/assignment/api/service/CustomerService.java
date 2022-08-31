package com.assignment.api.service;

import java.io.Serializable;
import java.util.Optional;

import com.assignment.api.entities.Customer;

public interface CustomerService extends BaseService<Customer, Serializable>{
	
	Optional<Customer> findById(int id);

}
