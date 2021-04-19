package com.banking.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.entities.TransactionType;
import com.banking.services.TransactionTypeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/transactiontype")
@Slf4j
public class TransactionTypeController {

	//private TransactionType transactionType;
	private TransactionTypeService service;
	
	public TransactionTypeController(TransactionTypeService service) {
		// TODO Auto-generated constructor stub
		this.service = service;
		log.info("constructor. Inject bean using constructor");
	}
	///////////////////////////////////////////////////////////////////////////
	@GetMapping(value="all", produces="application/json")
	public ResponseEntity<List<TransactionType>> getAll(){
		List<TransactionType> transTypeList = service.findAll();
		return ResponseEntity.ok(transTypeList);
	}
	
	///////////////////////////////////////////////////////////////////////////
	@GetMapping(value="id/{id}", produces="application/json")
	public ResponseEntity<TransactionType> getById(@PathVariable("id") int id){
		return ResponseEntity.ok(service.findById(id));
	}
	
	////////////////////////////////////////////////////////////////////////////
	@PostMapping(value="create", produces="application/text", consumes="application/json")
	public ResponseEntity<String> createNew(@RequestBody TransactionType transactionType){
		
		if (service.findByName(transactionType.getName()) != null) {
			return ResponseEntity.ok("Transaction Type "+transactionType.getName()+" already exists.");
		}
		
		try {
			service.save(transactionType);
			return ResponseEntity.ok("Successful");
		} catch(Exception e) {
			return ResponseEntity.ok(e.getMessage());
		}
	}
	////////////////////////////////////////////////////////////////////////////
	@PutMapping(value="update/id/{transactionTypeId}", produces="application/text", consumes="application/json")
	public ResponseEntity<String> update(@RequestBody TransactionType transactionType, @PathVariable("transactionTypeId") int id){
		
		if (service.findById(id) == null) {
			return ResponseEntity.ok("Transaction Type id "+id+" does not exist.");
		}
		
		try {
			transactionType.setId(id);
			service.save(transactionType);
			return ResponseEntity.ok("Successful");
		} catch(Exception e) {
			return ResponseEntity.ok(e.getMessage());
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////
	@DeleteMapping(value="delete/id/{transactiontypeid}", produces="application/json")
	public ResponseEntity<String> delete(@PathVariable("transactiontypeid") int id){
		
		TransactionType transactionType = service.findById(id);
		if (transactionType == null) {
			return ResponseEntity.ok("Transaction Type id "+id+" does not exist.");
		}
		
		try {
			service.delete(transactionType);;
			return ResponseEntity.ok("Successful");
		} catch(Exception e) {
			return ResponseEntity.ok(e.getMessage());
		}
	}
	

}
