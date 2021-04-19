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
@Table(name="banker")
public class Banker {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	@Column(name="Firstname")
	private String firstName;
	
	@Column(name="Lastname")
	private String lastName;
	
	@Column(name="MI")
	private String mi;
	
//	@Column(name="bankertypeid")
//	private int bankerTypeId;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="bankertypeid")
	private BankerType bankerType;
	
	public Banker() {
		// TODO Auto-generated constructor stub
	}

}
