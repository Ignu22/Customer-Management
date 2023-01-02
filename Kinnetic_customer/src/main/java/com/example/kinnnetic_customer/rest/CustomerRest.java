package com.example.kinnnetic_customer.rest;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.kinnnetic_customer.wrapper.CustomerWrapper;

@RequestMapping(path="/customer")
public interface CustomerRest {

	@PostMapping(path="/details")
	public ResponseEntity<String> details(@RequestBody(required = true)Map<String, String>requestMap);
	
	@GetMapping(path="/getAll")
	public ResponseEntity<List<CustomerWrapper>> getAllDetails();
	
	@GetMapping(path="/get/{id}")
	public ResponseEntity<CustomerWrapper> getById(@PathVariable Integer id);
	
	@DeleteMapping(path="/delete/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable Integer id);
}
