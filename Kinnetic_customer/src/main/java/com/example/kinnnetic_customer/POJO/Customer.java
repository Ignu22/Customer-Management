package com.example.kinnnetic_customer.POJO;

//import javax.persistence.NamedQuery;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

//import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@jakarta.persistence.NamedQuery(name = "Customer.getAllDetails",query= "select new com.example.kinnnetic_customer.wrapper.CustomerWrapper(u.id,u.name,u.address,u.phone,u.description) from Customer u")
@jakarta.persistence.NamedQuery(name = "Customer.getId",query= "select new com.example.kinnnetic_customer.wrapper.CustomerWrapper(u.id,u.name,u.address,u.phone,u.description) from Customer u where u.id=:id")


@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Embedded
	@Column(name="address")
	private Address address;
	
	@Column(name="number")
	private String phone;
	
	@Column(name="description")
	private String description;
	
	public Customer() {
		
	}

	public Customer(Integer id, String name, Address address, String phone, String description) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.description = description;
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
