package com.customer.main.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.main.dao.CustomerDao;
import com.customer.main.entity.Customer;
import com.customer.main.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	CustomerDao customerdao;
	@Override
	public List<Customer> getCustomers() {
		List<Customer> clist=customerdao.getCustomers();
		return clist;
	}
	@Override
	public Customer getCustomer(int cid) {
		Customer c= customerdao.getCustomer(cid);
		return c;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		Customer c= customerdao.addCustomer(customer);
		return c;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Customer c= customerdao.updateCustomer(customer);
		return c;
	}

	@Override
	public String deleteCustomer(int cid) {		
		customerdao.deleteCustomer(cid);
		return " deleted Customer Succesfully";

	}

	@Override
	public Customer getCustomerByEmail(String email) {
		Customer c= customerdao.getCustomerByEmail(email);
		return c;
	}

}
