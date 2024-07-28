package com.mnz.proj.domain.model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.mnz.proj.domain.model.enums.OrderStatus;
import com.mnz.proj.dto.OrderDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity(name="tb_order")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(columnDefinition="TIMESTAMP WITHOUT TIME ZONE")
	private Instant orderMoment;
	private OrderStatus orderStatus;
	@OneToMany(mappedBy="order")
	private List<Product> orderItens = new ArrayList<>();
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;
	
	
	public Order() {
		
	}
	
	public Order(Long id, Instant orderMoment, OrderStatus orderStatus, List<Product> orderItens, Client client) {
		this.id = id;
		this.orderMoment = orderMoment;
		this.orderStatus = orderStatus;
		this.orderItens = orderItens;
		this.client=client;
	}
	
	public Order(OrderDTO order) {
		this.id = order.getId();
		this.orderMoment = order.getOrderMoment();
		this.orderStatus = order.getOrderStatus();
		this.orderItens = order.getOrderItens().stream().map(p->new Product(p)).toList();
		this.client=new Client(order.getClient());
	}
	
	public Instant getOrderMoment() {
		return orderMoment;
	}
	public void setOrderMoment(Instant orderMoment) {
		this.orderMoment = orderMoment;
	}
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	public List<Product> getOrderItens() {
		return orderItens;
	}
	public void addOrderItens(Product orderItem) {
		this.orderItens.add(orderItem);
	}

	public Long getId() {
		return id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void setOrderItens(Product orderItem) {
		this.orderItens.add(orderItem);
	}


	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
}
