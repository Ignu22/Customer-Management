package com.example.kinnnetic_customer.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.example.kinnnetic_customer.wrapper.CustomerWrapper;

public interface CustomerService {

	ResponseEntity<String> details(Map<String, String> requestMap);

	ResponseEntity<List<CustomerWrapper>> getAllDetails();
	
	ResponseEntity<CustomerWrapper> getById(Integer id);

	ResponseEntity<String> deleteCustomer(Integer id);

}
