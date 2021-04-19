package com.banking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.entities.Account;
import com.banking.repositories.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository repo;
	
	public AccountService() {
		// TODO Auto-generated constructor stub
	}
	//////////////////////////////////////////////////////////////////
	public List<Account> findAll(){
		return repo.findAll();
	}
	
	/////////////////////////////////////////////////////////////////
	public Account findById(int id) {
		return repo.findById(id);
	}
	
	/////////////////////////////////////////////////////////////
	public List<Account> findByCustomerId(int customerId){
		return repo.findByCustomerId(customerId);
	}
	
	////////////////////////////////////////////////////////////
	public void save(Account account) throws Exception {
		if (account != null) {
			repo.saveAndFlush(account);
		}else {
			throw new Exception("Account cannot be empty.");
		}
		
	}
	
	///////////////////////////////////////////////////////////
	public void delete(int id) throws Exception {
		Account account = repo.findById(id);
		
		if (account!=null) {
			repo.delete(account);
		}else {
			throw new Exception("Account does not exist.");
		}
	}
	////////////////////////////////////////////////////////////
	public List<Account> findByCustomerIdAndAccountTypeId(int custId, int acctTypeId){
		List<Account> accountList = repo.findByCustomerIdAndAccountTypeId(custId, acctTypeId);
		return accountList;
	}

}
