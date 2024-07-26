package com.mnz.proj.service.imp;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.mnz.proj.domain.model.Client;
import com.mnz.proj.domain.model.Order;
import com.mnz.proj.domain.model.Product;
import com.mnz.proj.domain.repository.ClientRepository;
import com.mnz.proj.service.ClientService;

@Service
public class ClientServiceImp implements ClientService{
	
	private final ClientRepository clientRepository;
	
	
	
	public ClientServiceImp(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	@Override
	public Client findById(Long id) {
		// TODO Auto-generated method stub
		return clientRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public Client create(Client client) {
		if(clientRepository.existsById(client.getId()) && client.getId()!=null) {
			throw new IllegalArgumentException("Client already exist");
		}
		return clientRepository.save(client);
	}

	@Override
	public List<Client> findByName(String name) {
		// TODO Auto-generated method stub
		return clientRepository.findByName(name);
	}

	@Override
	public List<Client> findBySurname(String surname) {
		// TODO Auto-generated method stub
		return clientRepository.findBySurname(surname);
	}

	@Override
	public List<Client> findAll() {
		// TODO Auto-generated method stub
		return clientRepository.findAll();
	}

	@Override
	public List<Product> listProducts(Client client) {
		// TODO Auto-generated method stub
		return null;
	}


	
	

}
