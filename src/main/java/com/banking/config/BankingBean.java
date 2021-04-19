package com.banking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.banking.entities.Account;
import com.banking.entities.AccountType;
import com.banking.entities.Banker;
import com.banking.entities.BankerType;
import com.banking.entities.Customer;
import com.banking.entities.CustomerTransaction;
import com.banking.entities.TestStatic;
import com.banking.entities.TransactionType;

@Configuration
public class BankingBean {

	public BankingBean() {
		// TODO Auto-generated constructor stub
	}
	///////////////////////////////////////////////////////
	@Bean
	public Account getAccount() {
		return new Account();
	}
	///////////////////////////////////////////////////////
	@Bean
	public AccountType getAccountType() {
		return new AccountType();
	}
	///////////////////////////////////////////////////////
	@Bean
	public Banker getBanker() {
		return new Banker();
	}
	///////////////////////////////////////////////////////	
	@Bean
	public BankerType getBankerType() {
		return new BankerType();
	}
	///////////////////////////////////////////////////////	
	@Bean
	public Customer getCustomer() {
		return new Customer();
	}
	///////////////////////////////////////////////////////	
	@Bean
	public TransactionType getTransactionType() {
		return new TransactionType();
	}
	///////////////////////////////////////////////////////	
	@Bean
	public CustomerTransaction getCustomerTransaction() {
		return new CustomerTransaction();
	}
	///////////////////////////////////////////////////////	
	@Bean
	public ApplicationProps getApplicationProps() {
		return new ApplicationProps();
	}
	///////////////////////////////////////////////////////	
	@Bean
	public DatabaseProps getDatabaseProps() {
		return new DatabaseProps();
	}
	///////////////////////////////////////////////////////
	@Bean(name="static")
	public TestStatic getTestStatic() {
		return new TestStatic();
	}
	
}
