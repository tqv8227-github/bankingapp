package com.banking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.banking.entities.AccountType;

@RepositoryRestResource
public interface AccountTypeRepository extends JpaRepository<AccountType, Integer> {
	@Query(value="select a from AccountType a where a.id=:id")   // JPA Query
	public AccountType findById(@Param("id") int id);
	
	////////////////////////////////////////////////////////////////
	@Query(value="select distinct a from AccountType a where a.name=:name")
	public AccountType findByName(@Param("name") String accountTypeName);

}
