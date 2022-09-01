package com.assignment.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.api.entities.Customer;
import com.assignment.api.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomerInformation(@PathVariable("id") int customerId) {

		Optional<Customer> customer = customerService.findById(customerId);
		if (customer.isPresent())
			return new ResponseEntity<Customer>(customer.get(), HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);

	}

}
