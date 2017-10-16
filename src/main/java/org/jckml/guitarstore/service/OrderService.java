package org.jckml.guitarstore.service;

public interface OrderService {
	
	void processOrder(long  productId, long quantity);
}
