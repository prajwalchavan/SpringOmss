package com.project.omss.service;

import com.project.omss.entity.Cart;

public interface CartService {
	
	String saveOrUpdate(Cart cart);
	Cart addToCart(int userid, int productId, int quantity);
	Cart removeFromCart(int userid, int productId, int quantity);
}
