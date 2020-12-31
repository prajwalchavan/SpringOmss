package com.project.omss.service;

import java.util.List;

import com.project.omss.entity.Product;

public interface ProductService {

	List<Product> getAllProducts();

	String saveOrUpdate(Product product);
	
	Product updateProduct(Product product);
}
