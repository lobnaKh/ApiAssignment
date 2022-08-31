package com.assignment.api.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import com.assignment.api.entities.Transaction;

public class TransactionServiceImpl extends BaseServiceImpl<Transaction, Serializable> implements TransactionService {

	@Autowired
	private TransactionService transactionService;
	
	@Override
	public Transaction createTransaction(Transaction transaction) {
		return transactionService.save(transaction);
	}

	
}
