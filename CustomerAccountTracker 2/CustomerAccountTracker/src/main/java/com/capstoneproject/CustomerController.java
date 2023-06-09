package com.capstoneproject;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capstoneproject.Exception.RecordNotFoundException;
import com.capstoneproject.Service.CustomerService;
import com.capstoneproject.account.AccountBean;
import com.capstoneproject.account.CustomerBean;



@RestController
@RequestMapping("/customer")

public class CustomerController {
	
	@Autowired
	CustomerService cs;
	
	@RequestMapping(value="/addCustomer", method=RequestMethod.POST)
	public String CreateCustomer(CustomerBean cb, AccountBean ab)
	{	
		return cs.CreateCustomer(cb, ab);	
	}
	
	
	@RequestMapping(value="/updateCustomer", method=RequestMethod.PUT)
	public String UpdateCustomer(CustomerBean cb) throws RecordNotFoundException 
	{
		return cs.UpdateCustomer(cb);	
	}
	
	
	@RequestMapping(value="/getAllCustomers", method=RequestMethod.GET)
	public List<?> GetAllCustomers(CustomerBean cb) 
	{	
		return cs.GetAllCustomers();	
	}
	
	
	@RequestMapping(value="/getByAccNum/{accountNumber}", method=RequestMethod.GET)
	public CustomerBean GetCustomerByAccNum(@PathVariable("accountNumber") Long accountNumber) throws RecordNotFoundException
	{
		return cs.GetCustomerByAccNum(accountNumber);
	}
	
	
	@RequestMapping(value="deleteCustomerByAccNum/{accountNumber}", method=RequestMethod.DELETE)
	public String DeleteCustomerByAccNum(@PathVariable("accountNumber") Long accountNumber)
	{
		return cs.DeleteCustomerByAccNum(accountNumber);
	}

}
