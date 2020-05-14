package com.capg.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity

@Table(name="Online_Master")
public class Online{

	@Id
	private Long accNo;
	private String accHolder;
	private Long Phoneno;
	private String Email;
	private String Password;
	private Double balance;
		
	public Online() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Online(Long accNo, String accHolder,  Long phoneno, String email, String password,  Double balance) {
		super();
		this.accNo = accNo;
		this.accHolder = accHolder;
		this.Phoneno = phoneno;
		this.Email = email;
		this.Password = password;
		this.balance = balance;
	}



	public Long getAccNo() {
		return accNo;
	}



	public void setAccNo(Long accNo) {
		this.accNo = accNo;
	}



	public String getAccHolder() {
		return accHolder;
	}



	public void setAccHolder(String accHolder) {
		this.accHolder = accHolder;
	}



	public Long getPhoneno() {
		return Phoneno;
	}



	public void setPhoneno(Long phoneno) {
		this.Phoneno = phoneno;
	}



	public String getEmail() {
		return Email;
	}



	public void setEmail(String email) {
		this.Email = email;
	}



	public String getPassword() {
		return Password;
	}



	public void setPassword(String password) {
		this.Password = password;
	}



	public Double getBalance() {
		return balance;
	}



	public void setBalance(Double balance) {
		this.balance = balance;
	}



	@Override
	public String toString() {
		return "Online [successfully inserted]";
	}


	
	

	
	}
