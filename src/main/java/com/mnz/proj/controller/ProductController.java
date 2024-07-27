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

import com.mnz.proj.dto.ProductDTO;
import com.mnz.proj.service.imp.ProductServiceImp;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
	
	@Autowired
	private ProductServiceImp service;
	
	@GetMapping
	public Page<ProductDTO> findAll(Pageable pageable){
		return service.findAll(pageable);
	}
	
	@GetMapping(value="/{id}")
	public ProductDTO findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	public ProductDTO create(@RequestBody ProductDTO productDto) {
		return service.create(productDto);
	}
	@PutMapping(value="/{id}")
	public ProductDTO update(@PathVariable("id") Long id, @RequestBody ProductDTO productDto) {
		return service.update(id, productDto);
	}
	@DeleteMapping(value="/{id}")
	public void delete(@PathVariable("id") Long id) {
		service.deleteById(id);
	}
}
