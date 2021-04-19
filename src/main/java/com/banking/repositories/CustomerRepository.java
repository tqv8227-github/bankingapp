package com.banking.repositories;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.banking.entities.Customer;

//@RepositoryRestResource
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	@Query(value="select .* from customer a where a.id=:id")
	public Customer findById(@Param("id") int customerId);
	
	/////////////////////////////////////////////////////////
	//@Query(value="select a.* from customer a where upper(a.lastname) like concat('%',upper(:lastname),'%')")
	public List<Customer> findByLastNameContaining(String lName);
	
	/////////////////////////////////////////////////////////
	//@Query(value="select a.* from customer a where upper(a.firstname) like concat('%',upper(:firstname),'%')")
	public List<Customer> findByFirstNameContaining(String fName);
	
	/////////////////////////////////////////////////////////////////
	//@Query(value="select a from customer a where")
	public List<Customer> findByFirstNameContainingAndLastNameContaining(String firstName, String lastName);
}
