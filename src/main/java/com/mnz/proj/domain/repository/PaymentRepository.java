package com.mnz.proj.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mnz.proj.domain.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
