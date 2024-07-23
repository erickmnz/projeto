package com.mnz.proj.domain.model;

import com.mnz.proj.domain.model.enums.Section;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="tb_product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Section section;
	private Double price;
	
	public Product() {
		
	}
	
	public Product(Section section,String name, Double Price) {
		this.price=price;
		this.name = name;
		this.section=section;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	
}
