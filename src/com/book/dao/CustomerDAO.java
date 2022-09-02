package com.book.dao;

import java.util.List;

import com.book.pojo.Customer;

public interface CustomerDAO {

	public boolean addCustomer(Customer c);
	public boolean updateCustomer(Customer c);
	public boolean deleteCustomer(Integer custId);
	
	public List<Customer> showAllCustomer();
	public Customer showCustomerByEmail(String cemail);     
	public Customer showCustomerById(Integer custId);
	public List<Customer> showCustomerByFname(String fname);   
	
	
	
	
}
