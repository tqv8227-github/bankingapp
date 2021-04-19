package com.banking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.banking.entities.TransactionType;

@RepositoryRestResource
public interface TransactionTypeRepository extends JpaRepository<TransactionType, Integer> {
	@Query(value="select a from TransactionType a where a.id=:id")
	public TransactionType findById(@Param("id") int id);
	
	////////////////////////////////////////////////////////////////////
	@Query(value="select a.* from TransactionType a where a.name=:name", nativeQuery=true)
	public TransactionType findByName(@Param("name") String transactionTypeName);

}
