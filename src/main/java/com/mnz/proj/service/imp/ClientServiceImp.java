package com.mnz.proj.service.imp;

import java.util.NoSuchElementException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mnz.proj.domain.model.Client;
import com.mnz.proj.domain.repository.ClientRepository;
import com.mnz.proj.dto.ClientDTO;
import com.mnz.proj.service.ClientService;

@Service
public class ClientServiceImp implements ClientService{
	
	private final ClientRepository clientRepository;
	
	
	
	public ClientServiceImp(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	@Override
	public ClientDTO findById(Long id) {
		// TODO Auto-generated method stub
		Client client = clientRepository.findById(id).orElseThrow(NoSuchElementException::new);
		ClientDTO clientDTO = new ClientDTO(client);
		return clientDTO;
	}

	@Override
	public ClientDTO create(Client clientToSave) {
		if(clientRepository.existsById(clientToSave.getId()) && clientToSave.getId()!=null) {
			throw new IllegalArgumentException("Client already exist");
		}
		Client client = clientRepository.save(clientToSave);
		ClientDTO clientDTO = new ClientDTO(client);
		return clientDTO;
	}

	@Override
	public Page<ClientDTO> findByName(String name, Pageable pageable) {
		return clientRepository.findByName(name, pageable).map(c -> new ClientDTO(c));
	}

	@Override
	public Page<ClientDTO> findBySurname(String surname, Pageable pageable) {
		return clientRepository.findByName(surname, pageable).map(c -> new ClientDTO(c));
	}

	@Override
	public Page<ClientDTO> findAll(Pageable pageable) {
		return clientRepository.findAll(pageable).map(c -> new ClientDTO(c));
	}




	
	

}
