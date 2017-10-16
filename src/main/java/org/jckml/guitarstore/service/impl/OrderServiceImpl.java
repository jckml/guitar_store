package org.jckml.guitarstore.service.impl;

import org.jckml.guitarstore.domain.Product;
import org.jckml.guitarstore.domain.repository.ProductRepository;
import org.jckml.guitarstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private ProductRepository productRepository;
	
	public void processOrder(long productId, long quantity) {
		Product productById = productRepository.getProductById(productId);
		
		if(productById.getUnitsInStock() < quantity){
			throw new IllegalArgumentException("Zbyt malo towaru. Obecna liczba sztuk w magazynie "+ productById.getUnitsInStock());
		}
		
		productById.setUnitsInStock(productById.getUnitsInStock() - quantity);
	}
}
