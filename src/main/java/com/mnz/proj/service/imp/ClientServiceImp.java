package com.mnz.proj.service.imp;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mnz.proj.domain.model.Client;
import com.mnz.proj.domain.model.Order;
import com.mnz.proj.domain.repository.ClientRepository;
import com.mnz.proj.dto.ClientDTO;
import com.mnz.proj.service.ClientService;

@Service
public class ClientServiceImp implements ClientService{
	@Autowired
	private final ClientRepository clientRepository;
	
	
	
	public ClientServiceImp(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}
	
	@Transactional
	@Override
	public ClientDTO findById(Long id) {
		// TODO Auto-generated method stub
		Client client = clientRepository.findById(id).orElseThrow(NoSuchElementException::new);
		ClientDTO clientDTO = new ClientDTO(client);
		return clientDTO;
	}
	@Transactional
	@Override
	public ClientDTO create(ClientDTO clientToSave) {
		if(clientRepository.existsById(clientToSave.getId()) && clientToSave.getId()!=null) {
			throw new IllegalArgumentException("Client already exist");
		}
		return new ClientDTO(clientRepository.save(new Client(clientToSave)));
	}
	@Transactional
	@Override
	public Page<ClientDTO> findByName(String name, Pageable pageable) {
		return clientRepository.findByName(name, pageable).map(c -> new ClientDTO(c));
	}

	@Override
	public Page<ClientDTO> findBySurname(String surname, Pageable pageable) {
		return clientRepository.findByName(surname, pageable).map(c -> new ClientDTO(c));
	}
	@Transactional
	@Override
	public Page<ClientDTO> findAll(Pageable pageable) {
		return clientRepository.findAll(pageable).map(c -> new ClientDTO(c));
	}
	@Transactional
	@Override
	public ClientDTO update(Long id, ClientDTO clientDto) {
		Client client = clientRepository.getReferenceById(id);
		copyToClient(clientDto, client);
		
		return new ClientDTO(clientRepository.save(client));
	}
	@Transactional
	@Override
	public void deleteById(Long id) {
		clientRepository.deleteById(id);
	}
	private void copyToClient(ClientDTO clientDto, Client client) {
		client.setName(clientDto.getName());
		client.setSurname(clientDto.getSurname());
		client.setAddress(clientDto.getAddress());
		client.setBirthday(clientDto.getBirthday());
		client.setCep(clientDto.getCep());
		client.setEmail(clientDto.getEmail());
		clientDto.getOrders().stream().forEach(o->client.setOrders(new Order(o)));
		client.setPassword(clientDto.getPassword());
		client.setRoles(clientDto.getRoles());
		client.setTelephoneNumber(clientDto.getTelephoneNumber());
	}





	
	

}
