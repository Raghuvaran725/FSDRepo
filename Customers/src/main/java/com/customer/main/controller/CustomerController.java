package com.customer.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.customer.main.entity.Customer;
import com.customer.main.service.CustomerService;
@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	CustomerService customerservice;

	@GetMapping("/all")
	public ResponseEntity<List<Customer>> getCustomers() {
		List<Customer> customerList = customerservice.getCustomers();

		return new ResponseEntity<>(customerList, HttpStatus.OK);
	}
	@GetMapping("/getCustomer/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable(value="id") int cid) {
	    Customer customer = customerservice.getCustomer(cid); // Assuming the method is named getCustomerById
	    return customer != null ? ResponseEntity.ok(customer) : ResponseEntity.notFound().build();    
	}

	@PostMapping("/add")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		Customer c = customerservice.addCustomer(customer);
		return new ResponseEntity<>(c, HttpStatus.CREATED);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCustomer(@RequestParam int id) {
		customerservice.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PutMapping("/update")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
		Customer c = customerservice.updateCustomer(customer);
		return new ResponseEntity<>(c, HttpStatus.CREATED);
	}
	

	@GetMapping("/customer/{email}")
	public ResponseEntity<Customer>getCustomerByEmail(@PathVariable(value="email") String email){
		Customer customer = customerservice.getCustomerByEmail(email);
//		return new ResponseEntity<>(customer, HttpStatus.OK);
		return customer != null ? ResponseEntity.ok(customer) : ResponseEntity.notFound().build();
	}
}
