package com.banking.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.banking.entities.AccountType;
import com.banking.repositories.AccountTypeRepository;

@Service
public class AccountTypeService {

	private AccountType accountType;
	private AccountTypeRepository repo;
	
	public AccountTypeService(AccountType accountType, AccountTypeRepository repo) {
		this.accountType = accountType;
		this.repo = repo;
	}
	
	////////////////////////////////////////////////////////////////////////////////
	public List<AccountType> findAll(){
		return repo.findAll();
	}
	
	////////////////////////////////////////////////////////////////////////////////
	public AccountType findById(int id) {
		return repo.findById(id);
	}
	///////////////////////////////////////////////////////////////////////////////
	public void save(AccountType accountType) {
		repo.saveAndFlush(accountType);
	}
	//////////////////////////////////////////////////////////////////////////////
	public AccountType findByName(String name) {
		return repo.findByName(name);
	}


}
