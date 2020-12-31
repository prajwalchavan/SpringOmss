package com.project.omss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.omss.entity.Cart;
import com.project.omss.service.CartServiceImpl;

@RestController
public class CartController {
	
	@Autowired
	CartServiceImpl cartService;
	
	@PostMapping("/AddToCart")
	private String AddProduct(@RequestBody Cart Cart) {
	return Cart.getCartId() + " " + cartService.saveOrUpdate(Cart);
	}


}
