package com.mnz.proj.service.imp;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mnz.proj.domain.model.Order;
import com.mnz.proj.domain.repository.OrderRepository;
import com.mnz.proj.dto.OrderDTO;
import com.mnz.proj.service.OrderService;

@Service
public class OrderServiceImp implements OrderService{
	@Autowired
	private final OrderRepository repository;
	
	
	public OrderServiceImp(OrderRepository repository) {
		this.repository = repository;
	}

	@Override
	public OrderDTO findById(Long id) {
		return new OrderDTO(repository.findById(id).orElseThrow(NoSuchElementException::new)) ;
	}

	@Override
	public OrderDTO create(OrderDTO order) {
		return new OrderDTO(repository.save(new Order(order)));
	}


	@Override
	public List<OrderDTO> findAll() {
		return repository.findAll().stream().map(o->new OrderDTO(o)).toList();
	}



}
