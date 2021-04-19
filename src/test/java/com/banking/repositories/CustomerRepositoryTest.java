/**
 * 
 */
package com.banking.repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.banking.entities.Customer;

/**
 * @author Tuyen
 *
 */
@SpringBootTest
class CustomerRepositoryTest {
	@Autowired
	private CustomerRepository rep;

	/**
	 * @throws java.lang.Exception
	 */
//	public CustomerRepositoryTest(CustomerRepository repository) {
//		rep = repository;
//	}
	
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.banking.repositories.CustomerRepository#findById(int)}.
	 */
	@Test
	final void testFindByIdInt() {
		Customer customer = rep.findById(1);
		Assertions.assertEquals(customer.getId(), 1);
	}

	/**
	 * Test method for {@link com.banking.repositories.CustomerRepository#findByLastNameContaining(java.lang.String)}.
	 */
	@Test
	final void testFindByLastNameContaining() {
		
		System.out.println("testFindByLastNameContaining");
		List<Customer> customerList = rep.findByLastNameContaining("Vu");
		customerList.stream().map(a-> a.getFirstName()+" "+a.getLastName()).forEach(System.out::println);
		
		Assertions.assertEquals(customerList.size() > 0, true);
	}

	/**
	 * Test method for {@link com.banking.repositories.CustomerRepository#findByFirstNameContaining(java.lang.String)}.
	 */
	@Test
	final void testFindByFirstNameContaining() {
		System.out.println("testFindByFirstNameContaining");
		List<Customer> customerList = rep.findByFirstNameContaining("a");
		customerList.stream().map(a-> a.getFirstName()+" "+a.getLastName()).forEach(System.out::println);
		
		Assertions.assertEquals(customerList.size() > 0, true);
	}

	/**
	 * Test method for {@link com.banking.repositories.CustomerRepository#findByFirstNameContainingAndLastNameContaining(java.lang.String, java.lang.String)}.
	 */
	@Test
	final void testFindByFirstNameContainingAndLastNameContaining() {
		System.out.println("testFindByFirstNameContainingAndLastNameContaining");
		List<Customer> customerList = rep.findByFirstNameContainingAndLastNameContaining("T", "u");
		customerList.stream().map(a-> a.getFirstName()+" "+a.getLastName()).forEach(System.out::println);
		
		Assertions.assertEquals(customerList.size() > 0, true);
	}

	/**
	 * Test method for {@link org.springframework.data.jpa.repository.JpaRepository#findAll()}.
	 */
	@Test
	final void testFindAll() {
		System.out.println("testFindAll");
		List<Customer> customerList = rep.findAll();
		Assertions.assertEquals(customerList.size() > 0, true);
		
	}

}
