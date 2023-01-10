package com.example.customer_3.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.customer_3.model.Customer;
import com.example.customer_3.wrapper.CustomerWrapper;

public interface CustomerService {

	ResponseEntity<Customer> addCustomer(Customer customer);

	ResponseEntity<List<CustomerWrapper>> getAllCustomer();

	ResponseEntity<CustomerWrapper> getCustomer(Integer id);

}
