package com.mnz.proj.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mnz.proj.domain.model.Product;
import com.mnz.proj.domain.repository.ProductRepository;
import com.mnz.proj.dto.ProductDTO;
import com.mnz.proj.service.ProductService;

@Service
public class ProductServiceImp implements ProductService{
	@Autowired
	private ProductRepository pRepository;
	
	public ProductServiceImp(ProductRepository pRepository) {
		super();
		this.pRepository = pRepository;
	}	
	
	@Override
	public ProductDTO findById(Long id) {
		
		ProductDTO pDTO = new ProductDTO(pRepository.findById(id).orElseThrow());
		return pDTO;
	}



	@Override
	public ProductDTO create(ProductDTO productDto) {
		Product product = new Product();
		product.setName(productDto.getName());
		product.setDescription(productDto.getDescription());
		product.setSection(productDto.getSection());
		product.setPrice(productDto.getPrice());
		ProductDTO newProductDto = new ProductDTO(pRepository.save(product));
		return newProductDto;
	}

	@Override
	public Page<ProductDTO> findByName(String name, Pageable pageable) {
		return  pRepository.findByName(name, pageable).map(c ->new ProductDTO(c));
	}

	@Override
	public Page<ProductDTO> findAll(Pageable pageable) {
		return pRepository.findAll(pageable).map(c ->new ProductDTO(c));
	}

}
