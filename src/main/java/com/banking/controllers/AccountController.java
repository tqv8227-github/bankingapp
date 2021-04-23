package com.banking.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.config.ApplicationProps;
import com.banking.config.DatabaseProps;
import com.banking.entities.Account;
import com.banking.repositories.AccountRepository;
import com.banking.services.AccountService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private Account account; 
	private AccountService service;
	
	@Value("${spring.security.user.password}")
	private String pwd;
	
	@Autowired
	public Environment env;
	
	@Autowired
	private ApplicationProps appProps;
	
	@Autowired
	private DatabaseProps databaseProps;
	
	public AccountController(AccountService service) {  //constructor injection
		this.service = service;
	}
	
	/////////////////////////////////////////////////////////////
	@GetMapping(value="all", produces="application/json")
	public ResponseEntity<List<Account>> getAccountList() throws Exception{
		log.debug("List all account");
		List<Account> accountList = service.findAll();
		
		if (accountList == null || accountList.size() == 0 ) {
			throw new Exception("No record found");
		}
		
		//this.printProps();
		return ResponseEntity.ok(accountList.stream().filter(a -> { return a.getAmount() > 40000;}).collect(Collectors.toList()));
	}
	///////////////////////////////////////////////////////////////
	
	@GetMapping(value="id/{number}", produces="application/json")
	public ResponseEntity<Account> getAccount(@PathVariable (name="number") int accountNumber){
		log.debug("List given account");
		//Account account = rep.findById(accountNumber).get();
		Account account = service.findById(accountNumber);
		return ResponseEntity.ok(account);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	@GetMapping(value="customer/id/{number}", produces="application/text")
	public String getAccountForCustomer(@PathVariable (name="number") int customerId, ModelMap model){
		log.debug("List account by customer id");
		//Account account = rep.findById(accountNumber).get();
		List<Account> accountList = service.findByCustomerId(customerId);
		
		if (accountList.size() > 0) {
			model.put("customer", accountList.get(0).getCustomer());
		}
		
		model.put("accountList", accountList);
		return "./account/customeraccountlist";
	}
	
	/////////////////////////////////////////////////////////////////////
	@PostMapping(value="create", consumes="application/json", produces="application/text")
	public ResponseEntity<String> createNewAccount(@RequestBody Account account){
		try {
			service.save(account);
			return ResponseEntity.ok("successful");
		}catch (Exception e) {
			return ResponseEntity.ok(e.getMessage());
		}
	}
	//////////////////////////////////////////////////////////////////////
	public void printProps() {
		// using Environment to get prop from application.properties
		String userName = env.getProperty("spring.security.user.name");
		
		// Using @Value
		System.out.println("user name: "+userName+" and password: "+pwd);
		
		// Using @ConfigurationProperties in ApplicationProps class
		String propsStr = "Security: "+appProps.getSecurity()+". auth: "+appProps.getAuthentication()+". Env: "+appProps.getEnv()+". Menu: "+appProps.getMenu();
		System.out.println(propsStr);
		
		// Using @ConfigurationProperties in ApplicationProps class
		String dataBaseStr = "Database Infor. url: "+databaseProps.getUrl()+". user name: "+databaseProps.getUserName()+". password: "+databaseProps.getPassword()+". driver: "+databaseProps.getDriverClassName();
		System.out.println(dataBaseStr);
	}

}
