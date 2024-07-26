package com.mnz.proj.dto;

import java.util.ArrayList;
import java.util.List;

import com.mnz.proj.domain.model.Client;

public class ClientDTO {
	private Long id;
	private String name;
	private String surname;
	private String email;
	private String[] roles;
	private List<OrderDTO> orders = new ArrayList<>();
	public ClientDTO() {
		
	}

	public ClientDTO(Long id, String name, String surname, String email, String[] roles) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.roles = roles;
	}
	
	public ClientDTO(Client model) {
		this.id = model.getId();
		this.name = model.getName();
		this.surname = model.getSurname();
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

	
	
}
