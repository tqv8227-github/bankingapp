package com.banking.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.banking.entities.Customer;
import com.banking.entities.CustomerAccountView;
import com.banking.repositories.AccountRepositoryUsingJdbcTemplate;
import com.banking.repositories.CustomerRepository;
import com.banking.services.CustomerService;

import lombok.extern.slf4j.Slf4j;

//@RestController
@Controller
@Slf4j
@RequestMapping(value="/customer")
public class CustomerController {

	private Customer customer;
	private Customer customerII;
	private CustomerRepository repo;
	private AccountRepositoryUsingJdbcTemplate jdbcTemplate;
	private CustomerService service;
	
	public CustomerController(CustomerRepository repo, Customer customer, CustomerService service, AccountRepositoryUsingJdbcTemplate jdbcTemplate) {
		this.repo = repo;
		this.customerII = customer;
		this.service = service;
		this.jdbcTemplate = jdbcTemplate;
	}
	
//	//////////////////////////////////////////////////////////////////////////////////
//	@GetMapping(value="list/all", produces="application/json")
//	public ResponseEntity<List<Customer>> getAllCustomers() throws Exception{	
//		List<Customer> customerList = service.findAll();
//		return ResponseEntity.ok().body(customerList);
//	}
//	////////////////////////////////////////////////////////////////////////////////////
//	@GetMapping(value="id/{id}", produces="application/json")
//	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") int customerId) throws Exception{
//		return ResponseEntity.ok(service.findById(customerId));
//	}
//	/////////////////////////////////////////////////////////////////////////////////////////
//	@GetMapping(value="list/lastname/{lastname}", produces="application/json")
//	public ResponseEntity<List<Customer>> getCustomerByLastName(@PathVariable("lastname") String lastName) throws Exception{
//		return ResponseEntity.ok(repo.findByLastNameContaining(lastName));
//	}
//	///////////////////////////////////////////////////////////////////////////////////////
//	@GetMapping(value="list/firstname/{firstname}", produces="application/json")
//	public ResponseEntity<List<Customer>> getCustomerByFirstName(@PathVariable("firstname") String firstName) throws Exception{
//		return ResponseEntity.ok(repo.findByFirstNameContaining(firstName));
//	}
//	////////////////////////////////////////////////////////////////////////////////////////
//	@GetMapping(value="list/fullname", produces="application/json")
//	public ResponseEntity<List<Customer>> getCustomerByFullName(@RequestParam(value="firstName", required=true) String firstName, 
//																@RequestParam(value="lastName", required=true) String lastName) throws Exception {
//		List<Customer> custList = repo.findByFirstNameContainingAndLastNameContaining(firstName, lastName);
//		return ResponseEntity.status(200).body(custList);
//	}
//	/////////////////////////////////////////////////////////////////////////////////////
//	@GetMapping(value="view/account/list", produces="application/json")
//	public ResponseEntity<List<CustomerAccountView>> getAccountView(@RequestParam List<Integer> custIdList) throws Exception{
//		List<CustomerAccountView> custViewList = jdbcTemplate.getAccountViewsForCustIdList(custIdList);
//		
//		if (custViewList == null || custViewList.size()==0) {
//			throw new Exception("No records found...");
//		}
//		
//		return ResponseEntity.status(200).body(custViewList);
//	}
//	/////////////////////////////////////////////////////////////////////////////////////
//	@PostMapping(value="add", produces="application/json", consumes="application/json")
//	public ResponseEntity<Customer> addNewCustomer(@RequestBody Customer newCustomer) throws Exception {
//		Customer customer = new Customer();		
//		if (newCustomer != null && newCustomer.getLastName() != null && newCustomer.getFirstName() != null) {
//			customer = repo.save(newCustomer);
//		}else {
//			throw new Exception("Error: Please validate First name and Last Name.");
//		}
//		
//		return ResponseEntity.ok(customer);
//	}
//	/////////////////////////////////////////////////////////////////////////////////
//	@PutMapping(value="update", produces="application/json")
//	public ResponseEntity<Customer> updateUser(@RequestBody(required=true) Customer customer) throws Exception {
//		Customer lCustomer = service.findById(customer.getId());
//		
//		if (lCustomer != null && lCustomer.getLastName() != null && lCustomer.getFirstName() != null) {
//			lCustomer = repo.save(customer);	
//		}else {
//			throw new Exception("Error: Customer is not found");
//		}
//		
//		return ResponseEntity.ok(lCustomer);
//	}
//	
//	
	//////////////////////////////////////////////////////////////////////////////////
	@GetMapping(value="list/all")
	public String getAllCustomers2(ModelMap map) throws Exception{	
		List<Customer> customerList = service.findAll();
//		ModelMap map = new ModelMap();
		map.put("customerList", customerList);
		
		return "./customer/customerlist";
	}
	////////////////////////////////////////////////////////////////////////////////////
	@GetMapping(value="id/{id}", produces="application/json")
	public ResponseEntity<Customer> getCustomerById2(@PathVariable("id") int customerId) throws Exception{
		return ResponseEntity.ok(service.findById(customerId));
	}
	/////////////////////////////////////////////////////////////////////////////////////////
	@GetMapping(value="list/lastname/{lastname}", produces="application/json")
	public ResponseEntity<List<Customer>> getCustomerByLastName2(@PathVariable("lastname") String lastName) throws Exception{
		return ResponseEntity.ok(repo.findByLastNameContaining(lastName));
	}
	///////////////////////////////////////////////////////////////////////////////////////
	@GetMapping(value="list/firstname/{firstname}", produces="application/json")
	public ResponseEntity<List<Customer>> getCustomerByFirstName2(@PathVariable("firstname") String firstName) throws Exception{
		return ResponseEntity.ok(repo.findByFirstNameContaining(firstName));
	}
	////////////////////////////////////////////////////////////////////////////////////////
	@GetMapping(value="list/fullname", produces="application/json")
	public ResponseEntity<List<Customer>> getCustomerByFullName2(@RequestParam(value="firstName", required=true) String firstName, 
																@RequestParam(value="lastName", required=true) String lastName) throws Exception {
		List<Customer> custList = repo.findByFirstNameContainingAndLastNameContaining(firstName, lastName);
		return ResponseEntity.status(200).body(custList);
	}
	/////////////////////////////////////////////////////////////////////////////////////
	@GetMapping(value="view/account/list", produces="application/json")
	public ResponseEntity<List<CustomerAccountView>> getAccountView2(@RequestParam List<Integer> custIdList) throws Exception{
		List<CustomerAccountView> custViewList = jdbcTemplate.getAccountViewsForCustIdList(custIdList);
		
		if (custViewList == null || custViewList.size()==0) {
			throw new Exception("No records found...");
		}
		
		return ResponseEntity.status(200).body(custViewList);
	}
	/////////////////////////////////////////////////////////////////////////////////////
	@PostMapping(value="add", produces="application/json", consumes="application/json")
	public ResponseEntity<Customer> addNewCustomer2(@RequestBody Customer newCustomer) throws Exception {
		Customer customer = new Customer();		
		if (newCustomer != null && newCustomer.getLastName() != null && newCustomer.getFirstName() != null) {
			customer = repo.save(newCustomer);
		}else {
			throw new Exception("Error: Please validate First name and Last Name.");
		}
		
		return ResponseEntity.ok(customer);
	}
	/////////////////////////////////////////////////////////////////////////////////
	@PostMapping(value="update", consumes="application/x-www-form-urlencoded")
	public RedirectView updateUser(Customer customer) throws Exception {
		Customer lCustomer = service.findById(customer.getId());
		
		if (lCustomer != null && lCustomer.getLastName() != null && lCustomer.getFirstName() != null) {
			lCustomer = repo.save(customer);	
		}else {
			throw new Exception("Error: Customer is not found");
		}
		
		return new RedirectView("/customer/list/all");
	}
	//////////////////////////////////////////////////////////////////////////////
	@GetMapping(value="edit/id/{id}")
	public String editCustomer(@PathVariable("id") int custId, ModelMap map) throws Exception{
		Customer customer = service.findById(custId);
		
		if (customer == null) {
			throw new Exception("Customer with ID "+custId+" is not found");
		}
		
		map.put("customer", customer);
		return "./customer/edit";
	}
	
}
