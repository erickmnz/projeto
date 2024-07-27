package com.mnz.proj.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.mnz.proj.domain.model.Client;

public class ClientDTO {
	private Long id;
	private String name;
	private String surname;
	private Long telephoneNumber;
	private Long cep;
	private String address;
	private LocalDate birthday;
	private String password;
	private String email;
	private String[] roles;
	private List<OrderDTO> orders = new ArrayList<>();
	public ClientDTO() {
		
	}

	
	
	public ClientDTO(Long id, String name, String surname, Long telephoneNumber, Long cep, String address,
			LocalDate birthday, String password, String email, String[] roles, List<OrderDTO> orders) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.telephoneNumber = telephoneNumber;
		this.cep = cep;
		this.address = address;
		this.birthday = birthday;
		this.password = password;
		this.email = email;
		this.roles = roles;
		this.orders = orders;
	}



	public ClientDTO(Client model) {
		this.id = model.getId();
		this.name = model.getName();
		this.surname = model.getSurname();
		this.telephoneNumber = model.getTelephoneNumber();
		this.cep = model.getCep();
		this.address = model.getAddress();
		this.birthday = model.getBirthday();
		this.password = model.getPassword();
		this.email = model.getEmail();
		this.roles = model.getRoles();
		this.orders = model.getOrders().stream().map(o->new OrderDTO(o)).toList();
	}


	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getEmail() {
		return email;
	}

	public String[] getRoles() {
		return roles;
	}



	public Long getTelephoneNumber() {
		return telephoneNumber;
	}



	public Long getCep() {
		return cep;
	}



	public String getAddress() {
		return address;
	}



	public LocalDate getBirthday() {
		return birthday;
	}



	public String getPassword() {
		return password;
	}



	public List<OrderDTO> getOrders() {
		return orders;
	}
	
	
	
	
	
}
