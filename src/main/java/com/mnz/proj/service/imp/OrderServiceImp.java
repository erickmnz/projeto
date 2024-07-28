package com.mnz.proj.service.imp;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mnz.proj.domain.model.Client;
import com.mnz.proj.domain.model.Order;
import com.mnz.proj.domain.model.Product;
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
	@Transactional
	@Override
	public OrderDTO findById(Long id) {
		return new OrderDTO(repository.findById(id).orElseThrow(NoSuchElementException::new)) ;
	}
	@Transactional
	@Override
	public OrderDTO create(OrderDTO orderDto) {
		
		return new OrderDTO(repository.save(new Order(orderDto)));
	}

	@Transactional
	@Override
	public List<OrderDTO> findAll() {
		return repository.findAll().stream().map(o->new OrderDTO(o)).toList();
	}
	@Transactional
	public OrderDTO update(Long id, OrderDTO orderDto) {
		Order order = repository.getReferenceById(id);
		copyToOrder(orderDto, order);
		
		return new OrderDTO(repository.save(order));
	}
	@Transactional
	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	private void copyToOrder(OrderDTO orderDto, Order order) {
		order.setClient(new Client(orderDto.getClient()));
		orderDto.getOrderItens().stream().forEach(p->order.setOrderItens(new Product(p)));
		order.setOrderMoment(orderDto.getOrderMoment());
		order.setOrderStatus(orderDto.getOrderStatus());
	}
	


}
