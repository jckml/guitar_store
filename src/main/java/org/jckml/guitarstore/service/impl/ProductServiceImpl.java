package org.jckml.guitarstore.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jckml.guitarstore.domain.Product;
import org.jckml.guitarstore.domain.repository.ProductRepository;
import org.jckml.guitarstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;

	public List<Product> getAllProducts() {
		return productRepository.getAllProducts();
	}

	public Product getProductById(long productID) {
		return productRepository.getProductById(productID);
	}
	
	public List<Product> getProductsByCategory(String category) {
		return productRepository.getProductsByCategory(category);
	}

	public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
		return productRepository.getProductsByFilter(filterParams);
	}
	
	public void addProduct(Product product) {
		   productRepository.addProduct(product);
	}

}
