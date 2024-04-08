package com.customer.main.service;

import java.util.List;

import com.customer.main.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();

	public Customer getCustomer(int cid);

	public Customer addCustomer(Customer customer);

	public Customer updateCustomer(Customer customer);

	public String deleteCustomer(int cid);

	public Customer getCustomerByEmail(String email);
}
