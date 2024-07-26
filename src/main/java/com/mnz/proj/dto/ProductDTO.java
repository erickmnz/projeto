package com.mnz.proj.dto;

import com.mnz.proj.domain.model.Product;
import com.mnz.proj.domain.model.enums.Section;

public class ProductDTO {
	private Long id;
	private String name;
	private String description;
	private Double price;
	private Section section;

	public ProductDTO() {
		
	}
	
	public ProductDTO(Long id, String name, String description, Double price, Section section) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.section=section;
	}
	
	public ProductDTO(Product product) {
		this.id=product.getId();
		this.name = product.getName();
		this.description = product.getDescription();
		this.price = product.getPrice();
		this.section=product.getSection();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Double getPrice() {
		return price;
	}

	public Section getSection() {
		return section;
	}

	

}
