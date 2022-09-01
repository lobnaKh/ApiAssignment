package com.assignment.api.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assignment.api.entities.Account;
import com.assignment.api.entities.Customer;
import com.assignment.api.repositories.AccountRepository;

@Service("accountService")
@Transactional
public class AccountServiceImpl extends BaseServiceImpl<Account, Serializable> implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private CustomerService customerService;

	@Override
	public Account createNewAccount(double initialCredit, Customer customer) {
		Account account = new Account();
		account.setBalance(initialCredit);
		account.setCustomer(customer);
		Account savedAccount = accountRepository.save(account);

		customer.getAccounts().add(savedAccount);
		customerService.save(customer);
		return savedAccount;
	}

}
