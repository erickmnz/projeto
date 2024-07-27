package com.mnz.proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mnz.proj.dto.ClientDTO;
import com.mnz.proj.service.ClientService;

@RestController
@RequestMapping(value = "/users")
public class ClientController {

	@Autowired
	private ClientService service;

	
	@GetMapping(value="/{id}")
	public ClientDTO findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}
	
	@GetMapping
	public Page<ClientDTO> findAll(Pageable pageable){
		return service.findAll(pageable);
	}
	
	@PostMapping
	public ClientDTO create(@RequestBody ClientDTO clientDTO) {
		return service.create(clientDTO);
	}
	@PutMapping(value="/{id")
	public ClientDTO update(@PathVariable("id") Long id, @RequestBody ClientDTO clientDto) {
		return service.update(id, clientDto);
	}
	@DeleteMapping(value="/{id}")
	public void delete(@PathVariable("id") Long id) {
		service.deleteById(id);
	}
}
