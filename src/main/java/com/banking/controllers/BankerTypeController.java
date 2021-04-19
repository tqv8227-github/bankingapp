package com.banking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.entities.BankerType;
import com.banking.services.BankerTypeService;

@RestController
@RequestMapping("/bankertype")
public class BankerTypeController {

	@Autowired
	private BankerType bankerType;   // Field injection
	
	@Autowired
	private BankerTypeService service;
	
	public BankerTypeController() {
		// TODO Auto-generated constructor stub
	}
	
	///////////////////////////////////////////////////////
	@GetMapping(value="all", produces="application/json")
	public ResponseEntity<List<BankerType>> getAll() {
		List<BankerType> typeList = service.findAll();
		return ResponseEntity.ok(typeList);
	}
	///////////////////////////////////////////////////////
	@GetMapping(value="id/{id}", produces="application/json")
	public ResponseEntity<BankerType> getById(@PathVariable("id") int id) {
		BankerType typeList = service.findById(id);
		return ResponseEntity.ok(typeList);
	}
	///////////////////////////////////////////////////////
	@PostMapping(value="create", produces="application/json", consumes="application/json")
	public ResponseEntity<String> createNew(@RequestBody BankerType bankerType) {
		BankerType bType = service.findByName(bankerType.getName());
		
		if (bType != null) {
			return ResponseEntity.ok("Banker Type "+bankerType.getName()+" already exists");
		}
		
		try {
			service.save(bankerType);
			return ResponseEntity.ok("Successful");
		}catch(Exception e) {
			return ResponseEntity.ok(e.getMessage());
		}
	}
	///////////////////////////////////////////////////////
	@PutMapping(value="update/id/{bankerTypeId}", produces="application/json", consumes="application/json")
	public ResponseEntity<String> updateBankerType(@RequestBody BankerType bankerType, @PathVariable("bankerTypeId") int id) {
		BankerType bType = service.findById(id);
	
		if (bType == null) {
			return ResponseEntity.ok("Banker Type ID "+id+" does not exist");
		}
		
		try {
			bType.setName(bankerType.getName());
			service.save(bType);
			return ResponseEntity.ok("Successful");
		}catch(Exception e) {
			return ResponseEntity.ok(e.getMessage());
		}
	}
	//////////////////////////////////////////////////////////////
	@DeleteMapping(value="delete/id/{bankerTypeId}", produces="application/json", consumes="application/json")
	public ResponseEntity<String> deleteBankerType(@PathVariable("bankerTypeId") int id){
		BankerType bType = service.findById(id);
		
		if (bType == null) {
			return ResponseEntity.ok("Banker Type ID "+id+" does not exist");
		}
		
		try {
			service.delete(bType);
			return ResponseEntity.ok("Successful");
		}catch(Exception e) {
			return ResponseEntity.ok(e.getMessage());
		}
	}

}
