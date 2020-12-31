package com.project.omss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.omss.entity.Cart;
import com.project.omss.repository.CartJpaRepository;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
 	CartJpaRepository cartRepository;

	public String saveOrUpdate(Cart cart) {
		cartRepository.save(cart);
		return "Product Added To Cart";
	}

}
