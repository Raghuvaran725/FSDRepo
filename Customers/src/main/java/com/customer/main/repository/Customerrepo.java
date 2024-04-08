package com.customer.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.main.entity.Customer;

public interface Customerrepo extends JpaRepository<Customer,Integer> {

	Customer findByCustomerEmail(String email);

}
