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

		String password = "password";
		String email = "@cs414.com";

		Account manager = new Account();
		Account cashier = new Account();
		Account customer = new Account();
		Account cook = new Account();

		manager.setEmail("manager" + email);
		cashier.setEmail("cashier" + email);
		customer.setEmail("customer" + email);
		cook.setEmail("cook" + email);

		manager.setPassword(password);
		cashier.setPassword(password);
		customer.setPassword(password);
		cook.setPassword(password);

		add(manager);
		add(cashier);
		add(customer);
		add(cook);
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

