package com.pizzaApp.core;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class AccountRepository {

	private static AccountRepository instance = new AccountRepository();
	private Map<String, Account> accounts;
	
	private AccountRepository(){
		accounts = new HashMap<String, Account>();
	}

	public static AccountRepository sharedInstance() {
		return instance;
	}
	
	public Account get(String id) {
		synchronized(accounts) {
			return accounts.get(id);
		}
	}
	
	public void add(Account account) {
		synchronized(accounts) {
			this.accounts.put(account.getId(), account);
		}
	}
	
	public void replace(String id, Account account) {
		synchronized(accounts) {
			this.accounts.put(id, account);
		}
	}
	
	public List<Account> list() {
		synchronized(accounts) {
			return new ArrayList<Account>(accounts.values());
		}
	}

	public Account authenticate(String email, String password) {
		for(Account account : list()) {
			if(email.equals(account.getEmail())) {
				if(password.equals(account.getPassword())) return account;
			}
		}
		return null;
	}
}

