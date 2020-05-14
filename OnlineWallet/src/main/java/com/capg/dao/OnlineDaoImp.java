package com.capg.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capg.model.Online;

import java.util.Optional;
import com.capg.model.Transaction;

import com.capg.exceptions.IdNotFoundException;
@Repository
public  class OnlineDaoImp implements OnlineDao {

	@Autowired
	OnlineRepo brepo;
	@Autowired
	TransactionRepo trepo;

	@Override
	public Online createAccount(Online online) {

		  Transaction tran = new Transaction(); 
		  tran.setBalance(online.getBalance());
		  tran.setCreditedAmount(online.getBalance());
		  tran.setTransactionId((long)(Math.random()*100));
		  tran.setDebitedAmount((double) 0); 
		  tran.setAccNo(online.getAccNo()); 
		 
		  trepo.save(tran);
		/*
		 * Online ud =new Online(); ud.setAccHolder(online.getAccHolder());
		 * ud.setAccNo(online.getAccNo()); ud.setBalance(online.getBalance());
		 * ud.setEmail(online.getEmail()); ud.setPassword(online.getPassword());
		 * ud.setPhoneno(online.getPhoneno());
		 * 
		 */
		  return brepo.save(online);
		 
		
	}

	public void setBrepo(OnlineRepo brepo) {
		this.brepo = brepo;
	}

	@Override
	public Online showBalance(Long accNo)
	{

		return brepo.findByAccNo(accNo);
		
	}
	
@SuppressWarnings("null")
@Override
public boolean  loginUser(Online u)
{
    Online ud=brepo.findByAccNo(u.getAccNo());
		
		  if(ud!=null)
		  {
		   if((ud.getPassword()).equals(u.getPassword()))
		  { 
			 return true;
		  }
		  }
		   return false;
		  }
	



	@Override
	public Online deposite(Long accNo, Double depositeAmount) {
		
		
		
		Online online= brepo.findByAccNo(accNo);
		Double currentBal= online.getBalance();
		Transaction tran=new Transaction();
		tran.setTransactionId((long)(Math.random()*1000));
		tran.setCreditedAmount(depositeAmount);
		tran.setDebitedAmount((double)0);
		tran.setBalance(currentBal+depositeAmount);
		tran.setAccNo(accNo);
		trepo.save(tran);
	     online.setBalance(currentBal+depositeAmount);
		return brepo.save(online);
	}

	@Override
	public Online getAccount(Long accNo) 
	{
	
		return brepo.findByAccNo(accNo);
	}

	
	@Override
	public Online withdraw(Long accNo, Double withdrawAmount) {

		Online online = brepo.findByAccNo(accNo);
		Transaction tran = new Transaction();
		tran.setTransactionId((long)(Math.random()*1000));
		tran.setAccNo(accNo);
		tran.setDebitedAmount(withdrawAmount);
		tran.setCreditedAmount((double)0);
		Double currentBal = online.getBalance();
		tran.setBalance(currentBal-withdrawAmount);
		online.setBalance(currentBal-withdrawAmount);
		trepo.save(tran);
		return brepo.save(online);
	}

	
	
	  @Override public List<Transaction> printTransactions(Long accNo) 
	  {
		  
	  return trepo.findAllByAccNo(accNo);
	  }
	 

	@Override
	public Online fundTransfer(Long saccNo, Long raccNo, Double transferAmount) {
		
		Online sOnline=withdraw(saccNo, transferAmount);
		deposite(raccNo, transferAmount);
		
		return sOnline;
	}

	

	
}
