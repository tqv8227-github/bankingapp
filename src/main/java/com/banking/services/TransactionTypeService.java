package com.banking.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.banking.entities.TransactionType;
import com.banking.repositories.TransactionTypeRepository;

@Service
public class TransactionTypeService {

	private TransactionTypeRepository repo;
	
	public TransactionTypeService(TransactionTypeRepository repo) {
		// TODO Auto-generated constructor stub
		this.repo = repo;
	}
	
	////////////////////////////////////////////////////////////////
	public TransactionType findById(int id) {
		try {
			return repo.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	/////////////////////////////////////////////////////////////////
	public List<TransactionType> findAll(){
		return repo.findAll();
	}
	////////////////////////////////////////////////////////////////
	public void save(TransactionType transactionType) {
		repo.saveAndFlush(transactionType);
	}
	////////////////////////////////////////////////////////////////
	public TransactionType findByName(String name) {
		return repo.findByName(name);
	}
	////////////////////////////////////////////////////////////////
	public void delete(TransactionType transactionType) {
		repo.delete(transactionType);
	}

}
