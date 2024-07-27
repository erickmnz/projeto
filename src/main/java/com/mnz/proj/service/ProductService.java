package com.mnz.proj.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mnz.proj.domain.model.Product;
import com.mnz.proj.dto.ProductDTO;

public interface ProductService {
	ProductDTO findById(Long id);
	Page<ProductDTO> findByName(String name, Pageable pageable);
	Page<ProductDTO> findAll(Pageable pageable);
	ProductDTO create(ProductDTO productDto);
	ProductDTO update(Long id, ProductDTO productDto);
	void deleteById(Long id);
}
