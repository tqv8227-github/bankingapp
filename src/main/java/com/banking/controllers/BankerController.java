package com.banking.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.entities.Banker;
import com.banking.services.BankerService;

@RestController
@RequestMapping("/banker")
public class BankerController {

	private Banker banker;
	private BankerService service;
	
	public BankerController(BankerService service, Banker banker) {
		// TODO Auto-generated constructor stub
		this.banker=banker;
		this.service=service;
	}
	///////////////////////////////////////////////////////////////////////////////
	@GetMapping(value="all", produces="application/json")
	public ResponseEntity<List<Banker>> findAll(HttpServletRequest body){
		List<Banker> bankerList = service.findAll();
		return ResponseEntity.ok(bankerList);
	}
	
	////////////////////////////////////////////////////////////////////////////////
	@GetMapping(value="id/{bankerid}", produces="application/json")
	public ResponseEntity<Banker> findById(@PathVariable(value="bankerid") int id){
		Banker banker = service.findBankerById(id);
		return ResponseEntity.ok(banker);
				
	}
	//////////////////////////////////////////////////////////////////////////////////
	@PostMapping(value="create", produces="application/json", consumes="application/json")
	public String createNewBanker(@RequestBody Banker banker){	
		Banker thisBanker = banker;
		
		try {
			service.save(banker);
			return "successful";
		} catch (Exception e) {
			return e.getMessage();
		}
		
	}
	///////////////////////////////////////////////////////////////////////////////////////
	@PutMapping(value="update/{id}", produces="application/json", consumes="application/json")
	public String updateNewBanker(@PathVariable("id")int bankerId, @RequestBody Banker banker){
		try {
			Banker thisBanker = service.findBankerById(bankerId);
			
			if (thisBanker == null) {
				return "Banker with id "+bankerId+" is not found";
			}
			
			thisBanker.setBankerType(banker.getBankerType());
			thisBanker.setFirstName(banker.getFirstName());
			thisBanker.setLastName(banker.getLastName());
			
			service.save(thisBanker);
			return "successful";
		} catch (Exception e) {
			return e.getMessage();
		}
		
	}
	/////////////////////////////////////////////////////////////////////////////////////////
}
