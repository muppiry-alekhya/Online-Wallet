package com.capg.service;

import java.util.List;
import java.util.Optional;


import com.capg.model.Online;
import com.capg.model.Transaction;



public interface OnlineService {

	public abstract Online createAccount(Online online);

	public abstract Online showBalance(Long id);

	public abstract Online deposite(Long accNo, Double depositeAmount);

	public abstract Online getAccount(Long accNo);

	public abstract Online withdraw(Long accNo, Double withdrawAmount);

	 public abstract List<Transaction> printTransactions(Long accNo); 
	 


	public abstract Online fundTransfer(Long saccNo, Long raccNo, Double transferAmount);

	public abstract boolean loginUser(Online u);
	

	

}
