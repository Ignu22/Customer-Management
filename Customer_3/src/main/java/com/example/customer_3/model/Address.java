package com.example.customer_3.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address {
	
	@Column(name="country")
	private String country;
	
	@Column(name="state")
	private String state;

	@Column(name="city")
	private String city;

	@Column(name="street")
	private String street;

	public Address(String country, String state, String city, String street) {
		super();
		this.country = country;
		this.state = state;
		this.city = city;
		this.street = street;
	}
	
	public Address() {
		
	}

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

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

}
