package com.example.customer_3.model;


import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NamedQuery(name="Customer.getAllCustomer",query="select new com.example.customer_3.wrapper.CustomerWrapper(u.id,u.name,u.address,u.phone,u.description) from Customer u")
@NamedQuery(name = "Customer.getCustomer",query= "select new com.example.customer_3.wrapper.CustomerWrapper(u.id,u.name,u.address,u.phone,u.description) from Customer u where u.id=:id")

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
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

	public Customer(Integer id, String name, Address address, String phone, String description) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.description = description;
	}
	
	public Customer(){
		
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
