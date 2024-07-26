package com.mnz.proj.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mnz.proj.domain.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	Page<Product> findByName(String name, Pageable pageable);

}
