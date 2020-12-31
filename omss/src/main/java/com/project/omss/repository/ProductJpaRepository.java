package com.project.omss.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.project.omss.entity.Product;

public interface ProductJpaRepository extends CrudRepository<Product, Integer> {

	List<Product> findByProductName(String name);

	List<Product> findByCategory(String category);


}
