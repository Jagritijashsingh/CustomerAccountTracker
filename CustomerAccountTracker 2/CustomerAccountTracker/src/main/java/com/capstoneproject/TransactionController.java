package com.capstoneproject;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capstoneproject.Service.TransactionService;
import com.capstoneproject.account.AccountBean;
import com.capstoneproject.account.TransactionBean;


@RestController
@RequestMapping("/transaction")
public class TransactionController {
	
	@Autowired
	TransactionService ts;
	
	@RequestMapping(value="/transfer/{accountNumber}", method=RequestMethod.PUT)
	public String AmountTransfer(@PathVariable("accountNumber") Long accountNumber,TransactionBean tb, AccountBean ab)
	{
		return ts.AmountTransfer(accountNumber,tb,ab);
	}
	

}