package com.mnz.proj.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.mnz.proj.domain.model.Order;
import com.mnz.proj.domain.model.enums.OrderStatus;



public class OrderDTO {

	private Long id;
	private Instant orderMoment;
	private OrderStatus orderStatus;
	private List<ProductDTO> orderItens = new ArrayList<>();
	private ClientDTO client;
	private PaymentDTO payment;
	
	public OrderDTO() {
		
	}

	public OrderDTO(Long id, Instant orderMoment, OrderStatus orderStatus, List<ProductDTO> orderItens,
			ClientDTO client, PaymentDTO payment) {
		this.id = id;
		this.orderMoment = orderMoment;
		this.orderStatus = orderStatus;
		this.orderItens = orderItens;
		this.client = client;
		this.payment = payment;
	}
	
	public OrderDTO(Order  order) {
		this.id = order.getId();
		this.orderMoment = order.getOrderMoment();
		this.orderStatus = order.getOrderStatus();
		this.orderItens =order.getOrderItens().stream().map(p->new ProductDTO(p)).toList() ;
		this.client = new ClientDTO(order.getClient());
		this.payment = new PaymentDTO(order.getPayment());
	}

	
	public Long getId() {
		return id;
	}

	public Instant getOrderMoment() {
		return orderMoment;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public List<ProductDTO> getOrderItens() {
		return orderItens;
	}

	public ClientDTO getClient() {
		return client;
	}

	public PaymentDTO getPayment() {
		return payment;
	}
	
	
}
