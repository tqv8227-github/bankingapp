package com.banking.repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.banking.entities.CustomerAccountView;

@SpringBootTest
class AccountRepositoryUsingJdbcTemplateTest {
	
	@Autowired
	AccountRepositoryUsingJdbcTemplate repo;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	final void testGetAccountViewsForCustIdList() throws SQLException{
		List<Integer> idList = new ArrayList<Integer>();
		idList.add(1);
		idList.add(2);
		idList.add(3);
		idList.add(4);
		
		List<CustomerAccountView> objList = repo.getAccountViewsForCustIdList(idList);
		Assertions.assertEquals(objList.size()>0, true);
	}

}
