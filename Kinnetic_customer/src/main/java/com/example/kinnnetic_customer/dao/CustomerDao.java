package com.example.kinnnetic_customer.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kinnnetic_customer.POJO.Customer;
import com.example.kinnnetic_customer.wrapper.CustomerWrapper;

public interface CustomerDao extends JpaRepository<Customer, Integer> {

	List<CustomerWrapper> getAllDetails();

	CustomerWrapper getId(Integer id);

}
