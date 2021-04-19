package com.banking.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CustomerAccountViewRowMapper implements RowMapper{

	public CustomerAccountViewRowMapper() {
		// TODO Auto-generated constructor stub
	}
	
	//@Override
	public CustomerAccountView mapRow(ResultSet rs, int rowNum) throws SQLException{
		CustomerAccountView newObj = new CustomerAccountView();
		newObj.setAccountNum(rs.getInt("account_number"));
		newObj.setBalance(rs.getInt("balance"));
		newObj.setCustFullName(rs.getString("full_name"));
		newObj.setAccountType(rs.getString("account_type"));
		
		return newObj;
	}

}
