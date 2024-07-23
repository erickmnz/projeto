package com.mnz.proj.domain.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name="tb_client")
public class Client {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Long telephoneNumber;
	private Long cep;
	private String name;
	private String address;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Product> cart;
	public Client() {
	
	}

	public Client(Long telephoneNumber, Long cep, String name, String address) {
		this.telephoneNumber = telephoneNumber;
		this.cep = cep;
		this.name = name;
		this.address = address;
	}
	
	public Long getId() {
		return id;
	}

	public Long getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(Long telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public Long getCep() {
		return cep;
	}

	public void setCep(Long cep) {
		this.cep = cep;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Product> getProducts() {
		return cart;
	}

	public void addProducts(Product product) {
		this.cart.add(product);
	}
	
	
	
	
}
