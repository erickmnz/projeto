package com.mnz.proj.domain.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "tb_client")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long telephoneNumber;
	private Long cep;
	private String name;
	private String surname;
	private String address;
	private String email;
	private LocalDate birthday;
	private String password;
	private String[] roles;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="client")
	private List<Order> orders = new ArrayList<>();

	public Client() {

	}

	public Client(Long id, Long telephoneNumber, Long cep, String name,String surname, String address, String email,
			LocalDate birthday, String password, String[] roles, List<Order> orders) {
		this.id = id;
		this.telephoneNumber = telephoneNumber;
		this.cep = cep;
		this.name = name;
		this.surname=name;
		this.address = address;
		this.email = email;
		this.birthday = birthday;
		this.password = password;
		this.roles = roles;
		this.orders = orders;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String[] getRoles() {
		return roles;
	}

	public void setRoles(String[] roles) {
		this.roles = roles;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(Order order) {
		this.orders.add(order);
	}

}
