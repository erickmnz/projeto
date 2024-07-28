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

import com.mnz.proj.dto.OrderDTO;
import com.mnz.proj.dto.OrderDTO;
import com.mnz.proj.service.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
	@Autowired
	private OrderService service;
	
	
	@GetMapping(value="/{id}")
	public OrderDTO findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}
	
	@GetMapping
	public Page<OrderDTO> findAll(Pageable pageable){
		return service.findAll(pageable);
	}
	
	@PostMapping
	public OrderDTO create(@RequestBody OrderDTO orderDTO) {
		return service.create(orderDTO);
	}
	@PutMapping(value="/{id}")
	public OrderDTO update(@PathVariable("id") Long id, @RequestBody OrderDTO orderDto) {
		return service.update(id, orderDto);
	}	
	@DeleteMapping(value="/{id}")
	public void delete(@PathVariable("id") Long id) {
		service.deleteById(id);
	}
}
