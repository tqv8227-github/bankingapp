package com.banking.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.banking.entities.Banker;

@RepositoryRestResource
public interface BankerRepository extends JpaRepository<Banker, Integer> {
	
	@Query(value="select a from Banker a where a.id=:id")
	public Banker findById(@Param("id") int id);
	
	//////////////////////////////////////////////////////////////////
	@Query(value="select a from Banker a")
	public List<Banker> findAll();


}
