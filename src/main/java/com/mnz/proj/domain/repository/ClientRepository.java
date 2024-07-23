package com.mnz.proj.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mnz.proj.domain.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
