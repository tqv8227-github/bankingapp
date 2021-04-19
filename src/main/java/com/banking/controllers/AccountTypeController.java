package com.banking.controllers;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.entities.AccountType;
import com.banking.services.AccountTypeService;

@RestController
@RequestMapping("/accounttype")
public class AccountTypeController {

	private AccountType accountType;
	private AccountTypeService service;
	
	public AccountTypeController(AccountType accType, AccountTypeService accountSvc) {  // constructor injection
		// TODO Auto-generated constructor stub
		this.accountType = accType;
		this.service = accountSvc;
		
	}
	//////////////////////////////////////////////////////
	//	@Bean
	//	public AccountType getAccountType(AccountType accType) {
	//		return this.accountType = accType;
	//	}
	//	/////////////////////////////////////////////////////////
	//	@Bean
	//	public AccountTypeService getAccountTypeService(AccountTypeService accountSvc) {
	//		return this.service = accountSvc;
	//	}
	///////////////////////////////////////////////////////////
	@GetMapping(value="all", produces="application/json")
	public ResponseEntity<List<AccountType>> getAllAccountType(){
		List<AccountType> accountTypeList = service.findAll();
		return ResponseEntity.ok(accountTypeList);
	}
	
	///////////////////////////////////////////////////////////
	@GetMapping(value="id/{id}", produces="application/json")
	public ResponseEntity<AccountType> getById(@PathVariable("id") int id){
		AccountType accountType= service.findById(id);
		return ResponseEntity.ok(accountType);
	}
	
	////////////////////////////////////////////////////////////
	@PostMapping(value="create", produces="application/json", consumes="application/json")
	public ResponseEntity<String> createNewAccountType(@RequestBody AccountType accountType){
		AccountType acctType = service.findByName(accountType.getName());
		
		if (acctType != null) {
			return ResponseEntity.ok("Account Type "+accountType.getName()+" already exists.");
		}
		
		try {
			service.save(accountType);
			return ResponseEntity.ok("successfull");
		}catch(Exception e) {
			return ResponseEntity.ok(e.getMessage());
		}
	}
	
	////////////////////////////////////////////////////////////
	@PutMapping(value="update/id/{id}", produces="application/json", consumes="application/json")
	public ResponseEntity<String> createNewAccountType(@RequestBody AccountType accountType, @PathVariable("id") int id){
		AccountType acctType = service.findById(id);
		
		if (acctType == null) {
			return ResponseEntity.ok("Account Type id "+id+" does not exist.");
		}
		
		try {
			acctType.setName(accountType.getName());
			service.save(acctType);
			return ResponseEntity.ok("successfull");
		}catch(Exception e) {
			return ResponseEntity.ok(e.getMessage());
		}
}
	
}
