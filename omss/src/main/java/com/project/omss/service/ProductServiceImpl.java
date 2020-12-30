package com.project.omss.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.omss.entity.Product;
import com.project.omss.repository.ProductJpaRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
 	ProductJpaRepository productRepository;
	 
	@Override
	public String saveOrUpdate(Product product) {
		productRepository.save(product);
		return "Product Added";
	}
	
	@Override
	public List<Product> getAllProducts() {
		List<Product> product = new ArrayList<Product>();
       	productRepository.findAll().forEach(p1 -> product.add(p1));
		return product;
	}

	public List<Product> getProductByName(String name) {
		return productRepository.findByProductName(name);
	}

	public List<Product> getProductByCategory(String category) {
		return productRepository.findByCategory(category);
	}

}
