package com.banking.repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.banking.entities.Account;


@SpringBootTest
class AccountRepositoryTest {

	@Autowired
	AccountRepository repo;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	final void testFindByCustomerIdAndAccountTypeId() {
		List<Account> accountList = repo.findByCustomerIdAndAccountTypeId(1, 1);
		Assertions.assertEquals(accountList.size() > 0, true);
		
		accountList = repo.findByCustomerIdAndAccountTypeId(2, 4);
		Assertions.assertEquals(accountList.size() > 0, false);
		
	}

}
