package com.example.customer_3.wrapper;

import com.example.customer_3.model.Address;

public class CustomerWrapper {
	
	private Integer id;
	
	private String name;
	
	private Address address;
	
	private String phone;

	private String description;

	public CustomerWrapper(Integer id, String name, Address address, String phone, String description) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.description = description;
	}
	
	public CustomerWrapper() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
