package com.assignment.api.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import com.assignment.api.entities.Account;
import com.assignment.api.entities.Customer;
import com.assignment.api.entities.Transaction;
import com.assignment.api.repositories.AccountRepository;

public class AccountServiceImpl extends BaseServiceImpl<Account, Serializable> implements AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private TransactionService transactionService;

	@Override
	public void createNewAccount(double initialCredit, Customer customer) {
		Account account = new Account();
		accountRepository.save(account);
		
		customer.getAccounts().add(account);
		customerService.save(customer);
		
		if (initialCredit != 0) {
			Transaction transaction = new Transaction();
			Transaction createdTransaction = transactionService.createTransaction(transaction);
			account.getTransactions().add(createdTransaction);
			accountRepository.save(account);
		}

	}

}
