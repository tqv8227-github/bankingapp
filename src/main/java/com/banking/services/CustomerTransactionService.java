package com.banking.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.banking.entities.CustomerTransaction;
import com.banking.repositories.CustomerTransactionRepository;

@Service
public class CustomerTransactionService {

	private CustomerTransactionRepository repo;
	private BankerService bankerService;
	private AccountService accountService;
	
	public CustomerTransactionService(CustomerTransactionRepository repo, BankerService bService, AccountService aService) {
		this.repo = repo;
		this.accountService = aService;
		this.bankerService = bService;
	}
	
	/////////////////////////////////////////////////////////////////////////////
	public CustomerTransaction findById(int id) {
		return repo.findById(id);
	}
	
	/////////////////////////////////////////////////////////////////////////////
	public List<CustomerTransaction> findAll(){
		return repo.findAll();
	}
	
	///////////////////////////////////////////////////////////////////////////
	public List<CustomerTransaction> findByAccountId(int id){
		return repo.findByAccountId(id);
	}
	
	//////////////////////////////////////////////////////////////////////////
	public List<CustomerTransaction> findByAccountCustomerId(int id){
		return repo.findByAccountCustomerId(id);
	}
	
	//////////////////////////////////////////////////////////////////////////
	public List<CustomerTransaction> findByBankerId(int id){
		return repo.findByBankerId(id);
	}
	////////////////////////////////////////////////////////////////////////////
	public void save(CustomerTransaction transaction) throws Exception {
		
		if (bankerService.findBankerById(transaction.getBanker().getId())==null) {
			throw new Exception("Banker in this transaction is not valid.");
		}
		
		if (accountService.findById(transaction.getAccount().getId())==null) {
			throw new Exception("Acccount in this transaction is not valid.");
		}
		
		repo.saveAndFlush(transaction);
	}
	
	//////////////////////////////////////////////////////////////////////////
	public void delete(CustomerTransaction transaction) {
		
		if (transaction != null) {
			repo.delete(transaction);
		}
	}
	
}
