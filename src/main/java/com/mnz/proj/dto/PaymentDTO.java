package com.mnz.proj.dto;

import java.time.Instant;

import com.mnz.proj.domain.model.Payment;



public class PaymentDTO {

	private Long id;
	private Instant moment;
	private OrderDTO order;
	
	public PaymentDTO() {
		
	}

	public PaymentDTO(Long id, Instant moment, OrderDTO order) {
		super();
		this.id = id;
		this.moment = moment;
		this.order = order;
	}
	
	public PaymentDTO(Payment payment) {
		this.id = payment.getId();
		this.moment = payment.getMoment();
		this.order = new OrderDTO(payment.getOrder());
	}

	public Long getId() {
		return id;
	}

	public Instant getMoment() {
		return moment;
	}

	public OrderDTO getOrder() {
		return order;
	}
	
	
}
