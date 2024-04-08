package com.customer.main.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.customer.main.dao.CustomerDao;
import com.customer.main.entity.Customer;
import com.customer.main.repository.Customerrepo;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	Customerrepo customerrepo;
	
	
	@Override
	public List<Customer> getCustomers() {
		List<Customer> customerList = customerrepo.findAll();
		return customerList;
	}

	@Override
	public Customer getCustomer(int cid) {
		Customer cust = customerrepo.findById(cid).orElse(null);
		return cust;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		Customer cust = customerrepo.save(customer);
		return cust;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Customer cust = customerrepo.save(customer);
		return cust;
	}

	@Override
	public boolean deleteCustomer(int cid) {
		Customer cust = customerrepo.findById(cid).orElse(null);
		if (cust == null) {
			return false;
		}
		customerrepo.delete(cust);
		return true;
	}

	@Override
	public Customer getCustomerByEmail(String email) {
		Customer customer = customerrepo.findByCustomerEmail(email);
		return customer;
	}

}
