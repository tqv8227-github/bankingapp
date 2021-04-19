package com.banking.controllers;

import java.net.HttpCookie;
import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.entities.CustomerTransaction;
import com.banking.repositories.CustomerTransactionRepository;
import com.banking.services.CustomerTransactionService;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(value="/transaction")
public class CustomerTransactionController {

	private CustomerTransactionService service;
	
	// use dependency injection by constructor
	public CustomerTransactionController(CustomerTransactionService service) {
		this.service = service;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////
	@GetMapping(value="customer/id/{customerId}", produces="application/json")
	public ResponseEntity<List<CustomerTransaction>> getCustomerTransaction(@PathVariable("customerId") int id){
		List<CustomerTransaction> transactionList = service.findByAccountCustomerId(id);
		return  ResponseEntity.ok(transactionList);
	}
	
	////////////////////////////////////////////////////////////////////////////////////////
	@GetMapping(value="account/id/{id}", produces="application/json")
	public ResponseEntity<List<CustomerTransaction>> getAccountTransaction(@PathVariable("id") int accountId, HttpServletResponse response){
		
		List<HttpCookie> cookieList = new ArrayList<HttpCookie>();
		List<CustomerTransaction> transactionList = service.findByAccountId(accountId);

		//response.addCookie(new Cookie("test", "test"));
		//response.addHeader("MyHeader", "Hello World");
		//return ResponseEntity.ok().header("MyHeader2","Hello world 2.").body(transactionList);
		return  ResponseEntity.ok(transactionList);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////
	@GetMapping(value="banker/id/{bankerId}", produces="application/json")
	public ResponseEntity<List<CustomerTransaction>> getBankerTransaction(@PathVariable("bankerId") int id){
		List<CustomerTransaction> transactionList = service.findByBankerId(id);
		return ResponseEntity.ok(transactionList);
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////
	@PostMapping(value="create", consumes="application/json", produces="application/text")
	public ResponseEntity<String> createTransaction(@RequestBody CustomerTransaction transaction){
		try {
			service.save(transaction);
			return ResponseEntity.ok("Successful");
		}catch(Exception e) {
			return ResponseEntity.ok(e.getMessage());
		}
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////
	@DeleteMapping(value="delete/id/{transactionId}", produces="application/json")
	public ResponseEntity<String> deleteTransaction(@PathVariable("transactionId") int id){
		CustomerTransaction transaction = service.findById(id);
		
		try {
			service.delete(transaction);
			return ResponseEntity.ok("Successful");
		}catch(Exception e) {
			return ResponseEntity.ok(e.getMessage());
		}
	}

}
