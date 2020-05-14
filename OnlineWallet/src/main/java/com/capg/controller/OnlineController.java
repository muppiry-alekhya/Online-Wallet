package com.capg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.capg.model.Online;
import com.capg.model.Transaction;

import com.capg.service.OnlineService;

import com.capg.exceptions.AmountLessThanZeroException;
import com.capg.exceptions.IdNotFoundException;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class OnlineController {

	@Autowired
	private OnlineService service;
	
	
	@PostMapping(path="/create")
	public ResponseEntity<String> createAccount(@RequestBody Online online)
	{
		Online e = service.createAccount(online);
		if (e == null) {
			throw new IdNotFoundException("Enter Valid Id");
		} else
		{
			return new ResponseEntity<>("User created successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}
		
	
	
	@GetMapping(path="/show/{id}")
	
	public ResponseEntity<Online> showBalance(@PathVariable("id") Long id) {
		Online balance = service.showBalance(id);
		if (balance==null)
		{
			throw new IdNotFoundException("Id does not exist,so we couldn't fetch details");
		} else
		{
			return new ResponseEntity<>(balance, new HttpHeaders(), HttpStatus.OK);
		}
	}
	
	
	@GetMapping(path="/deposite/{accNo}&{depositeAmount}")
	public ResponseEntity<Object> deposite(@PathVariable Long accNo,@PathVariable Double depositeAmount)
	{
		//Online online=service.deposite(accNo, depositeAmount);
		if(depositeAmount==null)
		{
			throw new AmountLessThanZeroException("Amount cannot be less than zero");	
		}
		else
		{
			Online online=service.deposite(accNo, depositeAmount);
			return new ResponseEntity<>("Deposited successfully",new HttpHeaders(), HttpStatus.OK);
		}
	}
	
	
	
	@GetMapping(path="/get/{accNo}")
	public Online getAccount(@PathVariable Long accNo) 
	
	{
		return service.getAccount(accNo);
	}
	

	@PutMapping("/Loginuser")
	public ResponseEntity<String> loginUser(@RequestBody Online u)
	{
		
		 boolean flag=service.loginUser(u);
		if(flag==false)
		{
			throw new IdNotFoundException("User not found");
		}
		else 
		{
			return new ResponseEntity<>("Login successful", new HttpHeaders(), HttpStatus.OK);
		}
	}
	
	
	@GetMapping(path="/withdraw/{accNo}&{withdrawAmount}")
	public Online withdraw(@PathVariable Long accNo,@PathVariable Double withdrawAmount)
	
	{
		return service.withdraw(accNo,withdrawAmount);
	}
	
	
	
	  @GetMapping(path="/print/{accNo}") public List<Transaction>
	  printTransactions(@PathVariable Long accNo) 
	  
	  { 
		  
	 return service.printTransactions(accNo);
		 
	  }
	 
	
	
	@GetMapping(path="/fund/{saccNo}&{raccNo}&{transferAmount}")
	public ResponseEntity<Object> fundTranfer(@PathVariable Long saccNo,@PathVariable Long raccNo,@PathVariable Double transferAmount)
	
	{
		
		if(transferAmount==null)
		{
			throw new AmountLessThanZeroException("Amount cannot be less than zero");	
		}
		else
		{
			Online online=service.fundTransfer(saccNo,raccNo, transferAmount);
			return new ResponseEntity<>("Transfered successfully",new HttpHeaders(), HttpStatus.OK);
		}
	}

}





