package com.capg;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.capg.dao.*;
import com.capg.model.Online;
import com.capg.model.Transaction;
import com.capg.service.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class OnlineWalletApplicationTests {
	@Mock
	OnlineDaoImp dao; 
	
	@InjectMocks
	OnlineServiceImp service;
	
	@Before
	public void init()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	
	
	/*
	 * @Test public void testfundtransfer(){
	 * 
	 * when(dao.fundTransfer(1488L, 3951L,100.0)).thenReturn(new Online(10100));
	 * 
	 * assertEquals(10100,service.fundTransfer(1488L,3951L,100.0).getBalance(),0) ;
	 * } }
	 */
}
