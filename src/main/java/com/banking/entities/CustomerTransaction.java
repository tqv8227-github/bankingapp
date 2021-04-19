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
@Table(name="customertransaction")
public class CustomerTransaction {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	@Column(name="Amount")
	private int amount;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="transactiontypeid")
	private TransactionType transactionType;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="bankerid")
	private Banker banker;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="accountid")
	private Account account;
	
	public CustomerTransaction() {
		// TODO Auto-generated constructor stub
	}

}
