package com.banking.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.entities.TestStatic;

@RestController
public class TestStaticController {

	private TestStatic test;
	
	public TestStaticController() {
		// TODO Auto-generated constructor stub
	}
	
	private void getTestStatic(TestStatic test) {    // method injection
		this.test = test;
	}
	
	@GetMapping(value="/teststatic", produces="application/json")
	public String testStatic() {
		return test.getVAR_1();
	}
	
	

}
