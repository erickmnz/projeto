package com.mnz.proj.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mnz.proj.domain.model.Product;
import com.mnz.proj.domain.repository.ProductRepository;
import com.mnz.proj.dto.ProductDTO;
import com.mnz.proj.service.ProductService;


@Service
public class ProductServiceImp implements ProductService{
	@Autowired
	private final ProductRepository pRepository;
	
	public ProductServiceImp(ProductRepository pRepository) {
		this.pRepository = pRepository;
	}	
	@Transactional
	@Override
	public ProductDTO findById(Long id) {
		
		ProductDTO pDTO = new ProductDTO(pRepository.findById(id).orElseThrow());
		return pDTO;
	}


	@Transactional
	@Override
	public ProductDTO create(ProductDTO productDto) {
			return new ProductDTO(pRepository.save(new Product(productDto)));
	}
	@Transactional
	@Override
	public Page<ProductDTO> findByName(String name, Pageable pageable) {
		return  pRepository.findByName(name, pageable).map(c ->new ProductDTO(c));
	}
	@Transactional
	@Override
	public Page<ProductDTO> findAll(Pageable pageable) {
		return pRepository.findAll(pageable).map(c ->new ProductDTO(c));
	}
	@Transactional
	@Override
	public ProductDTO update(Long id, ProductDTO productDto) {
		Product product = pRepository.getReferenceById(id);
		copyToProduct(productDto, product);
		return new ProductDTO(pRepository.save(product));
	}
	
	private void copyToProduct(ProductDTO productDto, Product product) {
		product.setName(productDto.getName());
		product.setDescription(productDto.getDescription());
		product.setPrice(productDto.getPrice());
		product.setSection(product.getSection());
	}

	@Transactional
	@Override
	public void deleteById(Long id) {
		pRepository.deleteById(id);
	}
}
