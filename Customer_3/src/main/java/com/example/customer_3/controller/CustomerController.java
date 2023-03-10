package com.example.customer_3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer_3.model.Customer;
import com.example.customer_3.services.CustomerService;
import com.example.customer_3.wrapper.CustomerWrapper;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping(path="/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping(path="/add")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		
		try {
			return customerService.addCustomer(customer);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@GetMapping(path="/getAll")
	public ResponseEntity<List<CustomerWrapper>> getAllCustomer(){
		
		try {
			return customerService.getAllCustomer();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<CustomerWrapper> getCustomer(@PathVariable Integer id){
		try {
			return customerService.getCustomer(id);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable Integer id){
		try {
			return customerService.deleteCustomer(id);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<>("Bad Request",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PatchMapping(path="/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable Integer id,@RequestBody Customer customer){
		try {
			return customerService.updateCustomer(id,customer);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
