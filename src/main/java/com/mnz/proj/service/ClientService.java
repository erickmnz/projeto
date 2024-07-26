package com.mnz.proj.service;

import java.util.List;

import com.mnz.proj.domain.model.Client;
import com.mnz.proj.domain.model.Product;

public interface ClientService {
	Client findById(Long id);
	Client create(Client client);
	List<Client> findByName(String name);
	List<Client> findBySurname(String surname);
	List<Client> findAll();
	List<Product> listProducts(Client client);
}
