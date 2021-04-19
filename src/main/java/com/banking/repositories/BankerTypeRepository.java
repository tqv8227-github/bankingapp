package com.banking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.banking.entities.BankerType;

@RepositoryRestResource
public interface BankerTypeRepository extends JpaRepository<BankerType, Integer> {

	@Query(value="select a from BankerType a where a.id=:id")
	public BankerType findById(@Param("id") int id);
	
	/////////////////////////////////////////////////////////////
	@Query(value="select a from BankerType a where a.name=:name")
	public BankerType findByName(@Param("name") String typeName);
}
