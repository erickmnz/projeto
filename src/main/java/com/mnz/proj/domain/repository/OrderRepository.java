package com.mnz.proj.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mnz.proj.domain.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
