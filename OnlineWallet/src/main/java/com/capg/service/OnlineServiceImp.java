package com.capg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.dao.OnlineDao;
import com.capg.model.Online;
import com.capg.model.Transaction;
import com.capg.dao.OnlineDaoImp;
import com.capg.dao.OnlineRepo;
import com.capg.exceptions.IdNotFoundException;

@Service
public  class OnlineServiceImp implements OnlineService{
	@Autowired
	OnlineRepo brepo;

	@Autowired
	private OnlineDao dao;
	
	@Override
	public Online createAccount(Online online
			) {
		
		return dao.createAccount(online);
	}
	


	@Override
	public Online showBalance(Long accNo) {
	
		return dao.showBalance(accNo);
	}

	@Override
	public Online deposite(Long accNo, Double depositeAmount) 
	{
		
		return dao.deposite(accNo,depositeAmount);
	}

	@Override
	public Online getAccount(Long accNo)
	{
		
		return dao.getAccount(accNo);
	}
	

	

	
	
	@Override
	public Online withdraw(Long accNo, Double withdrawAmount) 
	{
	
		return dao.withdraw(accNo,withdrawAmount);
	}

	
	@Override
	public List<Transaction> printTransactions(Long accNo) 
	{
		
		return dao.printTransactions(accNo);
	}
	

	@Override
	public Online fundTransfer(Long saccNo, Long raccNo, Double transferAmount)
	
	{
	
		return dao.fundTransfer(saccNo,raccNo,transferAmount);
	}



	@Override
	public boolean loginUser(Online u) 
	
	{
		
		return dao.loginUser(u);        
	}

	
}
