package com.banking.repositories;

import java.util.Collections;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.banking.entities.Account;
import com.banking.entities.CustomerAccountView;
import com.banking.entities.CustomerAccountViewRowMapper;

@Repository
public class AccountRepositoryUsingJdbcTemplate {

	private JdbcTemplate template;
	
	public AccountRepositoryUsingJdbcTemplate(JdbcTemplate template) {
		this.template = template;
	}
	////////////////////////////////////////////////////////////////////
	public List<CustomerAccountView> getAccountViewsForCustIdList(List<Integer> custIdList){
		//SqlParameterSource params = new MapSqlParameterSource("custList", custIdList);
		String sqlStmt = "select a.id as account_number, a.amount as balance, b.firstName+' '+b.lastName as full_name,\r\n" + 
						 "  c.name as account_type\r\n" + 
						 "  from account a join customer b on a.CustomerId=b.Id join Accounttype c on c.id=a.AccountTypeId\r\n" + 
						 "  where b.id in (%s)";
		
		String inClause = String.join(",", Collections.nCopies(custIdList.size(), "?"));
		sqlStmt = String.format(sqlStmt, inClause);
		
		// create a functional interface
		RowMapper rowMapper = (rs, rowNum)->new CustomerAccountView(rs.getInt("account_number"),
								rs.getInt("balance"), rs.getString("full_name"),
									rs.getString("account_type"));
			
		//List<CustomerAccountView> viewList = template.query(sqlStmt, custIdList.toArray(), rowMapper);
		@SuppressWarnings("unchecked")
		List<CustomerAccountView> viewList = template.query(sqlStmt, custIdList.toArray(), rowMapper);
		
		return viewList;
	}

}
