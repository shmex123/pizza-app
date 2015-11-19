


package com.pizzaApp.api.controllers;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pizzaApp.core.AccountRepository;
import com.pizzaApp.core.Account;

@RestController
public class AccountController {
	
	private final AccountRepository repo;

	public AccountController() {
		repo = AccountRepository.sharedInstance();
	}

	@RequestMapping(method=RequestMethod.GET, value="/accounts")
	public List<Account> listAccounts() {
		return repo.list();
	}

	@RequestMapping(method=RequestMethod.GET, value="/accounts/{accountId}")
	public ResponseEntity<Account> getAccount(@PathVariable(value="accountId") String accountId) {
		return new ResponseEntity<Account>(repo.get(accountId), HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.POST, value="/register")
	public Account createAccount(@RequestBody final Account account) {
		repo.add(account);
		return account;
	}

	@RequestMapping(method=RequestMethod.PUT, value="/accounts/{accountId}")
	public ResponseEntity<Account> updateAccount(@PathVariable(value="accountId") String accountId,
		@RequestBody final Account account) {
		if(repo.get(accountId) ==  null) throw new AccountNotFoundException();
		repo.replace(accountId, account);
		return new ResponseEntity<Account>(account, HttpStatus.OK);
	}

	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Account does not exist!")
	public class AccountNotFoundException extends RuntimeException {
	}
}
