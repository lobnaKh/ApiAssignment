package com.assignment.api.service;

import java.io.Serializable;

import com.assignment.api.entities.Account;
import com.assignment.api.entities.Customer;

public interface AccountService extends BaseService<Account, Serializable> {

	Account createNewAccount(double initialCredit, Customer customer);

}
