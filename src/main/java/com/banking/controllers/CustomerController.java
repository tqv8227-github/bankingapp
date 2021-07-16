package com.banking.controllers;

import java.util.Collections;
import java.util.Comparator;
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
import com.banking.services.AccountService;
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
	private AccountService accountService;
	
	public CustomerController(CustomerRepository repo, Customer customer, CustomerService service, AccountRepositoryUsingJdbcTemplate jdbcTemplate,
							  AccountService accountService) {
		this.repo = repo;
		this.customerII = customer;
		this.service = service;
		this.jdbcTemplate = jdbcTemplate;
		this.accountService = accountService;
	}
	
	//////////////////////////////////////////////////////////////////////////////////
	@GetMapping(value="list/all")
	public String getAllCustomers2(@RequestParam(value="sortBy", required=false, defaultValue="asc") String sortOrder,  
									@RequestParam(value="fieldName", required=false, defaultValue="firstName") String sortedFieldName, 
									ModelMap map) throws Exception{	
		
		
		Comparator<Customer> sortByFirstNameDesc = (cust1, cust2)-> cust2.getFirstName().compareTo(cust1.getFirstName());
		Comparator<Customer> sortByFirstNameAsc = (cust1, cust2)-> cust1.getFirstName().compareTo(cust2.getFirstName());
		Comparator<Customer> sortByLastNameDesc = (cust1, cust2)-> cust2.getLastName().compareTo(cust1.getLastName());
		Comparator<Customer> sortByLastNameAsc = (cust1, cust2)-> cust1.getLastName().compareTo(cust2.getLastName());
		
		List<Customer> customerList = service.findAll();
		
		if (sortOrder.equalsIgnoreCase("desc") && sortedFieldName.equalsIgnoreCase("firstName")) {
			Collections.sort(customerList, sortByFirstNameDesc);
			map.put("sortBy", "asc");
		}else if (sortOrder.equalsIgnoreCase("asc") && sortedFieldName.equalsIgnoreCase("firstName")) {
			Collections.sort(customerList, sortByFirstNameAsc);
			map.put("sortBy", "desc");
		}else if (sortOrder.equalsIgnoreCase("desc") && sortedFieldName.equalsIgnoreCase("lastName")) {
			Collections.sort(customerList, sortByLastNameDesc);
			map.put("sortBy", "asc");
		}else if (sortOrder.equalsIgnoreCase("asc") && sortedFieldName.equalsIgnoreCase("lastName")) {
			Collections.sort(customerList, sortByLastNameAsc);
			map.put("sortBy", "desc");
		}
		
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
	@GetMapping(value="add/new")
	public String addNewCustomer() throws Exception {
		return "./customer/add";	
	}
	/////////////////////////////////////////////////////////////////////////////////////
	@PostMapping(value="add", consumes="application/x-www-form-urlencoded")
	public String addNewCustomer(Customer newCustomer, ModelMap model) throws Exception {
		Customer customer = new Customer();	
		
		if (newCustomer != null && newCustomer.getLastName() != null && newCustomer.getFirstName() != null) {
			customer = repo.save(newCustomer);
		}else {
			String message = "Error: Please validate First name and Last Name.";
			String forwardPage = "/bankingapp/customer/list/all";
			model.put("errorMsg", message);
			model.put("forwardPage", forwardPage);
			model.put("forwardPageName", "back to Customer List");
			return "./error/displayerror";
		}
		
		model.put("customerList", service.findAll());
		return "./customer/customerlist";		
	}
	/////////////////////////////////////////////////////////////////////////////////
	@PostMapping(value="update", consumes="application/x-www-form-urlencoded")
	public String updateUser(Customer customer, ModelMap model) throws Exception {
		Customer lCustomer = service.findById(customer.getId());
		
		if (lCustomer != null && lCustomer.getLastName() != null && lCustomer.getFirstName() != null) {
			lCustomer = repo.save(customer);	
		}else {
			// throw new Exception("Error: Customer is not found");
			String message = "Error: Customer ID is not found.";
			String forwardPage = "/bankingapp/customer/list/all";
			model.put("errorMsg", message);
			model.put("forwardPage", forwardPage);
			model.put("forwardPageName", "back to Customer List");
			return "./error/displayerror";
		}
		
		model.put("customerList", service.findAll());
		return "./customer/customerlist";		
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
	////////////////////////////////////////////////////////////////////////////////
	@GetMapping(value="delete/id/{id}", produces="application/text")
	public String deleteCustomer(@PathVariable("id") int custId, ModelMap model) throws Exception{
		Customer customer = service.findById(custId);
		
		if (customer==null || accountService.findByCustomerId(custId).size() > 0) {
			String message = "Can't delete. Either customer does not exist or customer still owns an account. ";
			String forwardPage = "/bankingapp/customer/list/all";
			model.put("errorMsg", message);
			model.put("forwardPage", forwardPage);
			model.put("forwardPageName", "back to Customer List");
			return "./error/displayerror";
		}else {
			repo.delete(customer);
			model.put("customerList", service.findAll());
			return "./customer/customerlist";
		}
		
	}
	
}
