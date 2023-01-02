package com.example.kinnnetic_customer.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.kinnnetic_customer.POJO.Address;
import com.example.kinnnetic_customer.POJO.Customer;
import com.example.kinnnetic_customer.constants.CustomerConstants;
import com.example.kinnnetic_customer.dao.CustomerDao;
import com.example.kinnnetic_customer.service.CustomerService;
import com.example.kinnnetic_customer.utils.CustomerUtils;
import com.example.kinnnetic_customer.wrapper.CustomerWrapper;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerDao customerDao;
	
	@Override
	public ResponseEntity<String> details(Map<String, String> requestMap) {
		
		try {
			
			if(validateDetailsMap(requestMap)) {
				customerDao.save(getCustomerFromMap(requestMap));
				return CustomerUtils.getResponseEntity("Data Added Successfully", HttpStatus.OK);
			}else {
				return CustomerUtils.getResponseEntity(CustomerConstants.INVALID_DATA, HttpStatus.BAD_REQUEST);
			}
			
		}catch(Exception ex) {
			
			ex.printStackTrace();
		}
		
		return CustomerUtils.getResponseEntity(CustomerConstants.Something_Wrong, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private boolean validateDetailsMap(Map<String, String> requestMap) {

		if(requestMap.containsKey("name") && requestMap.containsKey("address")  && 
				requestMap.containsKey("phone") && requestMap.containsKey("description")){
			return true;
		}
		return false;
	}
	
	private Customer getCustomerFromMap(Map<String,String>requestMap) {
		
		Customer customer = new Customer();
		Address address = new Address();
		customer.setName(requestMap.get("name"));
		customer.setAddress(address);
		//address.setCity(requestMap.get("city"));
//		address.setCountry(requestMap.get("country"));
//        address.setHousename(requestMap.get("housename"));
       // address.setState(requestMap.get("state"));
		customer.setPhone(requestMap.get("phone"));
		customer.setDescription(requestMap.get("description"));
		return customer;
		
		
	}

	@Override
	public ResponseEntity<List<CustomerWrapper>> getAllDetails() {
		try {
			return new ResponseEntity<>(customerDao.getAllDetails(),HttpStatus.OK);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<CustomerWrapper> getById(Integer id) {
		
		try {
			//Optional<Customer> optional=customerDao.findById(id);
			
			return new ResponseEntity<>(customerDao.getId(id),HttpStatus.OK);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return new ResponseEntity<CustomerWrapper>( HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<String> deleteCustomer(Integer id) {
		try {
			Optional<Customer> optional= customerDao.findById(id);
			if(!optional.isEmpty()) {
				customerDao.deleteById(id);
				return CustomerUtils.getResponseEntity("Customer Details Deleted Successfully", HttpStatus.OK);
			}
			return CustomerUtils.getResponseEntity("Customer Id Doesn't Exist", HttpStatus.BAD_REQUEST);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return CustomerUtils.getResponseEntity(CustomerConstants.Something_Wrong, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
