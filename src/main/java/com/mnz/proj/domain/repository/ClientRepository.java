package com.mnz.proj.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mnz.proj.domain.model.Client;
import com.mnz.proj.domain.model.Order;

public interface ClientRepository extends JpaRepository<Client, Long>{
	List<Client> findByName(String name);
	List<Client> findBySurname(String surname);
}
