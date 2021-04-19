package com.banking.controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.banking.entities.Customer;

@SpringBootTest
class CustomerControllerTest {

	@Autowired
	private CustomerController controller;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	final void testGetCustomerByFullName() {
		try {
			ResponseEntity<List<Customer>> result = controller.getCustomerByFullName2("u", "V");
			int statusCode = result.getStatusCodeValue();
			Assertions.assertEquals(statusCode, 200);
		} catch (Exception e) {
			fail("failed: "+e.getMessage());
		}
	}

	@Test
	final void testAddNewCustomer() {
		//fail("Not yet implemented"); // TODO
	}

	@Test
	final void testUpdateUser() {
		//fail("Not yet implemented"); // TODO
	}

}
