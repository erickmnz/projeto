package com.mnz.proj.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mnz.proj.domain.model.Client;
import com.mnz.proj.dto.ClientDTO;

public interface ClientService {
	ClientDTO findById(Long id);
	ClientDTO create(Client client);
	Page<ClientDTO> findBySurname(String surname, Pageable pageable);
	Page<ClientDTO> findByName(String name, Pageable pageable);
	Page<ClientDTO> findAll(Pageable pageable);
}
