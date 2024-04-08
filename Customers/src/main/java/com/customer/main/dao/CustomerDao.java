package com.customer.main.dao;

import java.util.List;

import com.customer.main.entity.Customer;
public interface CustomerDao {
	public List<Customer> getCustomers();

	public Customer getCustomer(int cid);

	public Customer addCustomer(Customer customer);

	public Customer updateCustomer(Customer customer);

	public boolean deleteCustomer(int cid);

	public Customer getCustomerByEmail(String email);
}
