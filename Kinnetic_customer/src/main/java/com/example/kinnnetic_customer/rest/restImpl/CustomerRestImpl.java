package com.example.kinnnetic_customer.rest.restImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.kinnnetic_customer.constants.CustomerConstants;
import com.example.kinnnetic_customer.rest.CustomerRest;
import com.example.kinnnetic_customer.service.CustomerService;
import com.example.kinnnetic_customer.utils.CustomerUtils;
import com.example.kinnnetic_customer.wrapper.CustomerWrapper;

@RestController
public class CustomerRestImpl implements CustomerRest{

	@Autowired
	CustomerService customerService;
	
	@Override
	public ResponseEntity<String> details(Map<String, String> requestMap) {
		
		try{
			
			return customerService.details(requestMap);
					
		}catch(Exception ex) {
			
			ex.printStackTrace();
		}
		
		return CustomerUtils.getResponseEntity(CustomerConstants.Something_Wrong,HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<List<CustomerWrapper>> getAllDetails() {
		
		try {
			
			return customerService.getAllDetails();
			
		}catch(Exception ex) {
			
			ex.printStackTrace();
		}
		
		return new ResponseEntity<List<CustomerWrapper>>(new ArrayList<>(),HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<CustomerWrapper> getById(Integer id) {
		
		try {
			return customerService.getById(id);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<CustomerWrapper>( HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<String> deleteCustomer(Integer id) {
		try {
			return customerService.deleteCustomer(id);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return CustomerUtils.getResponseEntity(CustomerConstants.Something_Wrong, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
