package com.mnz.proj.service;

import java.util.List;

import com.mnz.proj.domain.model.Order;

public interface OrderService {
	Order findById(Long id);
	Order create(Order order);
	List<Order> findByName(String name);
	List<Order> findBySurname(String surname);
	List<Order> findAll();
}
