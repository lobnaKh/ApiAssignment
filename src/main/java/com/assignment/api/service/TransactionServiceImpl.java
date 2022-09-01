package com.assignment.api.service;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assignment.api.entities.Account;
import com.assignment.api.entities.Transaction;
import com.assignment.api.repositories.TransactionRepository;

@Service("transactionService")
@Transactional
public class TransactionServiceImpl extends BaseServiceImpl<Transaction, Serializable> implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private AccountService accountService;

	@Override
	public Transaction createTransaction(Account account, double credit) {
		Transaction savedTransaction = transactionRepository
				.save(new Transaction(credit, new Date(), "initial credit"));

		account.getTransactions().add(savedTransaction);
		accountService.save(account);

		return savedTransaction;
	}

}
