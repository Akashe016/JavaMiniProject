package com.example.AccountDetails.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.AccountDetails.model.AccountEntity;
import com.example.AccountDetails.response.AccountResponse;
import com.example.AccountDetails.service.AccountService;

@RestController
@RequestMapping("/atm")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@PostMapping("/CreateAccount")
	public AccountResponse CreateAccount(@RequestBody AccountEntity accountEntity) {
		
		return accountService.account(accountEntity);
	}
	
	@GetMapping("/Balance")
	public List<AccountEntity> miniStatement(int pinNumber, Long phoneNumber) {
		
		return accountService.balance(pinNumber, phoneNumber);
	}
	
	@PutMapping("/PinChange")
	public AccountResponse pinChange(@RequestBody AccountEntity accountEntity) {
		
		return accountService.pinExchange(accountEntity);
	}
	
	@PutMapping("/Deposit")
	public AccountResponse deposit(@RequestBody AccountEntity accountEntity) {
		
		return accountService.deposit(accountEntity);
	}
	
	@PutMapping("/Withdraw")
	public AccountResponse withdraw(@RequestBody AccountEntity accountEntity) throws IOException {
		
		return accountService.withdraw(accountEntity);
	}
	
}
