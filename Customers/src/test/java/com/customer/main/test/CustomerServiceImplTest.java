package com.customer.main.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.customer.main.dao.CustomerDao;
import com.customer.main.entity.Customer;
import com.customer.main.serviceimpl.CustomerServiceImpl;

class CustomerServiceImplTest {

    @Mock
    private CustomerDao customerDaoMock;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetCustomers() {
        // Arrange
        Customer customer1 = new Customer();
        customer1.setCustomerId(1);
        customer1.setCustomerName("John");

        Customer customer2 = new Customer();
        customer2.setCustomerId(2);
        customer2.setCustomerName("Alice");

        List<Customer> expectedCustomers = Arrays.asList(customer1, customer2);

        when(customerDaoMock.getCustomers()).thenReturn(expectedCustomers);

        // Act
        List<Customer> actualCustomers = customerService.getCustomers();

        // Assert
        assertEquals(expectedCustomers.size(), actualCustomers.size());
        assertEquals(expectedCustomers.get(0).getCustomerName(), actualCustomers.get(0).getCustomerName());
        assertEquals(expectedCustomers.get(1).getCustomerName(), actualCustomers.get(1).getCustomerName());
    }

    @Test
    void testGetCustomer() {
        // Arrange
        int customerId = 1;
        Customer expectedCustomer = new Customer();
        expectedCustomer.setCustomerId(customerId);
        expectedCustomer.setCustomerName("John");

        when(customerDaoMock.getCustomer(customerId)).thenReturn(expectedCustomer);

        // Act
        Customer actualCustomer = customerService.getCustomer(customerId);

        // Assert
        assertEquals(expectedCustomer.getCustomerId(), actualCustomer.getCustomerId());
        assertEquals(expectedCustomer.getCustomerName(), actualCustomer.getCustomerName());
    }

    // Similarly, write tests for other methods like addCustomer, updateCustomer, deleteCustomer, and getCustomerByEmail
}

