package com.banking.entities;

import lombok.Data;
import lombok.NonNull;

@Data
public class CustomerAccountView {

	@NonNull
	private int accountNum;
	@NonNull
	private int balance;
	@NonNull
	private String custFullName;
	@NonNull
	private String accountType;
	
	public CustomerAccountView() {
		// TODO Auto-generated constructor stub
	}
	
	public CustomerAccountView(int accountNum, int balance, String custFullName, String accountType) {
		this.accountNum = accountNum;
		this.balance = balance;
		this.custFullName = custFullName;
		this.accountType = accountType;
	}

}
