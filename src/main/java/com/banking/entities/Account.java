package com.banking.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="Account")
public class Account {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
//	@Column(name="AccountTypeId")
//	private int accountTypeId;
	
	@Column(name="Amount")
	private int amount;
	
//	@Column(name="CustomerId")
//	private int customerId;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="accounttypeid", nullable=false)
	private AccountType accountType;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="customerid", nullable=false)
	private Customer customer;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

}
