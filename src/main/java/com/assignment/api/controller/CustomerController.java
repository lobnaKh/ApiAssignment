package com.assignment.api.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

	@RequestMapping("/")
	public String hello() {
		return "hello";
	}

	@RequestMapping("/newAccount/{customerId}/{initialCredit}")
	public void openNewAccount(@PathVariable(value = "customerId") int id,
			@PathVariable(value = "initialCredit") double initialCredit) {

	}

}
