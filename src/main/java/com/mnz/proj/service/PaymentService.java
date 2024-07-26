package com.mnz.proj.service;

import java.util.List;

import com.mnz.proj.domain.model.Payment;

public interface PaymentService {
	Payment findById(Long id);
	Payment create(Payment payment);
	List<Payment> findByName(String name);
	List<Payment> findBySurname(String surname);
	List<Payment> findAll();

}
