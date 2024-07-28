package com.mnz.proj.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mnz.proj.dto.OrderDTO;

public interface OrderService {
	OrderDTO findById(Long id);
	Page<OrderDTO> findAll(Pageable pageable);
	OrderDTO create(OrderDTO order);
	OrderDTO update(Long id, OrderDTO orderDto);
	void deleteById(Long id);
}
