package com.mnz.proj.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mnz.proj.domain.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
	Page<Client> findByName(String name, Pageable page);
	Page<Client> findBySurname(String surname, Pageable page);
	
}
