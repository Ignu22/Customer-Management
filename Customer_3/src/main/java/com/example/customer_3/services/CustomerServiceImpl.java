package com.example.customer_3.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.customer_3.model.Customer;
import com.example.customer_3.repository.CustomerRepository;
import com.example.customer_3.wrapper.CustomerWrapper;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public ResponseEntity<Customer> addCustomer(Customer customer) {
		
		try {
			Customer customer1 = customerRepository.save(customer);
			return new ResponseEntity<>(customer1,HttpStatus.CREATED);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<List<CustomerWrapper>> getAllCustomer() {
		try {
			return new ResponseEntity<>(customerRepository.getAllCustomer(),HttpStatus.OK);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<CustomerWrapper> getCustomer(Integer id) {
		try {
			return new ResponseEntity<>(customerRepository.getCustomer(id),HttpStatus.OK);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
