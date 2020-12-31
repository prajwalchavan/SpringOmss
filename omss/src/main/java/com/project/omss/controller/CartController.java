package com.project.omss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	public String AddProduct(@RequestParam int userId, @RequestParam int productId, @RequestParam int quantity) {
	  cartService.addToCart(userId, productId, quantity);
	  return " Product Added/Updated in Cart";
	}
	
	@PostMapping("/RemoveFromCart")
	public String RemoveProduct(@RequestParam int userId, @RequestParam int productId, @RequestParam int quantity) {
		Cart c = cartService.removeFromCart(userId, productId, quantity);
		if(  c != null) {
			
			return "Product removed from cart";
		}
		else {
			return "Entered Product not found in cart";
		}
	}
	
	@GetMapping("/ViewCart")
	private List<Cart> vewCartDetails(@RequestParam("userId") int userId) {
		return cartService.getCartByUserId(userId);
	}


}
