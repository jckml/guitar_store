package org.jckml.guitarstore.domain.repository.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jckml.guitarstore.domain.Product;
import org.jckml.guitarstore.domain.repository.ProductRepository;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryProductRepository implements ProductRepository{
	
	private List<Product> listOfProducts = new ArrayList<Product>();
	
	public InMemoryProductRepository() {
		Product sg = new Product(0,"SG Standard", new BigDecimal(3500));
	    sg.setDescription("Gitara Gibson SG Standard z 2009 roku, kolor czarny, nowa, kraj produkcji USA");
	    sg.setCategory("elektryczna");
	    sg.setManufacturer("Gibson");
	    sg.setUnitsInStock(1000);

	    Product telecaster = new Product(1,"Fender Telecaster", new BigDecimal(2700));
	    telecaster.setDescription("Gitara Fender Telecaster z 1989 roku, kolor bialy, uzywana, kraj produkcji Japonia");
	    telecaster.setCategory("elektryczna");
	    telecaster.setManufacturer("Dell");
	    telecaster.setUnitsInStock(1000);

	    Product guild = new Product(2,"Guild Acoustic", new BigDecimal(8700));
	    guild.setDescription("Gitara akustyczna Guild, rocznik 2007, używana, drewno - mahon");
	    guild.setCategory("akustyczna");
	    guild.setManufacturer("Guild");
	    guild.setUnitsInStock(1000);

	    listOfProducts.add(sg);
	    listOfProducts.add(telecaster);
	    listOfProducts.add(guild);

	}

	public List<Product> getAllProducts() {
		return listOfProducts;
	}

	public Product getProductById(long productId) {
		Product productById = null;
		
		for(Product product : listOfProducts) {
			if(product.getProductId() == productId){
				productById = product;
				break;
			}
		}
		
		if(productById == null){
			throw new IllegalArgumentException("Brak produktu o wskazanym id: "+ productId);
		}
		
		return productById;
	}
	
	public List<Product> getProductsByCategory(String category) {
		List<Product> productsByCategory = new ArrayList<Product>();
			
		for(Product product: listOfProducts) {
			if(category.equalsIgnoreCase(product.getCategory())){
				productsByCategory.add(product);
			}
		}
		
		return productsByCategory;
	}

	public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
		Set<Product> productsByBrand = new HashSet<Product>();
		Set<Product> productsByCategory = new HashSet<Product>();

		Set<String> criterias = filterParams.keySet();
		
		if(criterias.contains("brand")) {
			for(String brandName: filterParams.get("brand")) {
				for(Product product: listOfProducts) {
					if(brandName.equalsIgnoreCase(product.getManufacturer())){
						productsByBrand.add(product);
					}
				}
			}
		}
		
		if(criterias.contains("category")) {
			for(String category: filterParams.get("category")) {
				productsByCategory.addAll(this.getProductsByCategory(category));
			}
		}
		
		productsByCategory.retainAll(productsByBrand);
		
		return productsByCategory;
	}
	
	public void addProduct(Product product) {
		   listOfProducts.add(product);
	}

}
