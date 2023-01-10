package com.example.customer_3.services;

import java.util.List;
import java.util.Optional;

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

	@Override
	public ResponseEntity<String> deleteCustomer(Integer id) {
		try {
			Optional<Customer> optional= customerRepository.findById(id);
			if(!optional.isEmpty()) {
				customerRepository.deleteById(id);
				return new ResponseEntity<>("Customer Details Deleted Successfully", HttpStatus.OK);
			}
			return new ResponseEntity<>("Customer Id Doesn't Exist", HttpStatus.BAD_REQUEST);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<Customer> updateCustomer(Integer id, Customer customer) {
		try {
			Optional<Customer> optional =customerRepository.findById(id);
			if(!optional.isEmpty()) {
				Customer customer1 = customerRepository.findById(id).get();
				customer1.setName(customer.getName());
				customer1.setAddress(customer.getAddress());
				customer1.setDescription(customer.getDescription());
				customer1.setPhone(customer.getPhone());
				customerRepository.save(customer1);
				return new ResponseEntity<>(customer1,HttpStatus.CREATED);
			}
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
