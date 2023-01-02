package com.example.kinnnetic_customer.POJO;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {

	
	private String country;
	
	
	private String state;

	
	private String city;

	
	private String housename;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getHousename() {
		return housename;
	}

	public void setHousename(String housename) {
		this.housename = housename;
	}
	
	public Address(String country, String state, String city, String housename) {
		super();
		this.country = country;
		this.state = state;
		this.city = city;
		this.housename = housename;
	}
	
	public Address() {
		
	}

	
	
}
