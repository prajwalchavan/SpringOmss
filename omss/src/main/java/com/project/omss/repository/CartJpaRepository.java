package com.project.omss.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.omss.entity.Cart;

public interface CartJpaRepository extends JpaRepository<Cart,Integer>{
	List<Cart> findByUserId(int userId);

	Cart findByProductId(int productId);
}
