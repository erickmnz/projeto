package com.mnz.proj.service;

import java.util.List;

import com.mnz.proj.domain.model.Order;
import com.mnz.proj.dto.OrderDTO;

public interface OrderService {
	OrderDTO findById(Long id);
	List<OrderDTO> findAll();
	OrderDTO create(OrderDTO order);
}
