package org.jckml.guitarstore.domain.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jckml.guitarstore.domain.Product;

public interface ProductRepository {

	List <Product> getAllProducts();
	
	Product getProductById(long productID);
	
	List<Product> getProductsByCategory(String category);

	Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);
	
	void addProduct(Product product);		
}
