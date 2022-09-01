package com.assignment.api.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.api.entities.Account;
import com.assignment.api.entities.Customer;
import com.assignment.api.service.AccountService;
import com.assignment.api.service.CustomerService;
import com.assignment.api.service.TransactionService;

@RestController
public class AccountController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private AccountService accountService;

	@Autowired
	private TransactionService transactionService;

	@GetMapping("/")
	public String hello() {
		return "Welcome to Api Assignment";
	}

	@PostMapping("/accounts")
	public ResponseEntity<Account> createCustomerAccount(@RequestBody Map<String, Object> body) {
		Optional<Customer> customer = customerService.findById((int) body.get("customerId"));
		if (customer.isPresent()) {
			Account savedAccount = accountService.createNewAccount((double) body.get("initialCredit"), customer.get());

			if ((double) body.get("initialCredit") != 0) {
				transactionService.createTransaction(savedAccount, (double) body.get("initialCredit"));
			}
			return new ResponseEntity<Account>(savedAccount, HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
	}

}
