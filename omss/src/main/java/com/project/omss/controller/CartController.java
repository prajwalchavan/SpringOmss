package com.project.omss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.omss.entity.Cart;
import com.project.omss.service.CartServiceImpl;

@RestController
public class CartController {

	@Autowired
	CartServiceImpl cartService;

	@PostMapping("/AddToCart")
	public Cart AddProduct(@RequestParam int userId, @RequestParam int productId, @RequestParam int quantity) {
		return cartService.addToCart(userId, productId, quantity);
	}

}
