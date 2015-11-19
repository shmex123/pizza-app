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
	
	public Account get(String email) {
		synchronized(accounts) {
			return accounts.get(email);
		}
	}
	
	public void add(Account account) {
		synchronized(accounts) {
			this.accounts.put(account.getEmail(), account);
		}
	}
	
	public void replace(Account account) {
		synchronized(accounts) {
			this.accounts.put(account.getEmail(), account);
		}
	}
	
	public List<Account> list() {
		synchronized(accounts) {
			return new ArrayList<Account>(accounts.values());
		}
	}
}

