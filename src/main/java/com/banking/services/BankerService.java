package com.banking.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.banking.entities.Banker;
import com.banking.repositories.BankerRepository;

@Service
public class BankerService {

	private BankerRepository repo;
	private Banker banker;
	
	public BankerService(BankerRepository repository, Banker banker) {
		// TODO Auto-generated constructor stub
		this.repo = repository;
		this.banker = banker;
	}
	
	//////////////////////////////////////////////////////////
	public Banker findBankerById(int id){
		return repo.findById(id);
	}
	
	///////////////////////////////////////////////////////////
	public List<Banker> findAll(){
		return repo.findAll();
	}
	
	////////////////////////////////////////////////////////////
	public void save(Banker banker) {
		//repo.save(banker);
		repo.saveAndFlush(banker);
	}
	////////////////////////////////////////////////////////////

}
