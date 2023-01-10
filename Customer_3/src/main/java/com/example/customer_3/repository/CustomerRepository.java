package com.example.customer_3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.customer_3.model.Customer;
import com.example.customer_3.wrapper.CustomerWrapper;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	List<CustomerWrapper> getAllCustomer();
	
	CustomerWrapper getCustomer(Integer id);

}
