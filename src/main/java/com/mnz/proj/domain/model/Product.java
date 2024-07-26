package com.mnz.proj.domain.model;

import java.util.Objects;

import com.mnz.proj.domain.model.enums.Section;
import com.mnz.proj.dto.ProductDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name="tb_product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private Section section;
	private Double price;
	@ManyToOne
	@JoinColumn(name="order_id")
	private Order order;
	
	
	public Product() {
		
	}

	public Product(Long id, String name, String description, Section section, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.section = section;
		this.price = price;
	}
	public Product(ProductDTO dto) {
		this.id = dto.getId();
		this.name = dto.getName();
		this.description = dto.getDescription();
		this.section = dto.getSection();
		this.price = dto.getPrice();
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
