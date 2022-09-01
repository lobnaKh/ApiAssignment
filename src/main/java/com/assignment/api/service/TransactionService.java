package com.assignment.api.service;

import java.io.Serializable;

import com.assignment.api.entities.Account;
import com.assignment.api.entities.Transaction;

public interface TransactionService extends BaseService<Transaction, Serializable> {

	Transaction createTransaction(Account account, double credit);
}
