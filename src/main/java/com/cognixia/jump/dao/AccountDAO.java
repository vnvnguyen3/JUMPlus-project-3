package com.cognixia.jump.dao;

import java.util.List;

import com.cognixia.jump.model.Account;

public interface AccountDAO {

	boolean addAccount(Account a);
	
	List<Account> getAllAccounts();
	
	Account getAccountById(int id);
	
	boolean updateAccount(Account a);
	
}
