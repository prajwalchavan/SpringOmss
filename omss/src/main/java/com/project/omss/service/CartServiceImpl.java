package com.project.omss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.omss.entity.Cart;
import com.project.omss.entity.Product;
import com.project.omss.repository.CartJpaRepository;
import com.project.omss.repository.ProductJpaRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartJpaRepository cartRepository;

	@Autowired
	ProductJpaRepository productRepository;

	@Override
	public Cart addToCart(int userid, int productId, int quantity) {
		List<Cart> cartDetails = cartRepository.findByUserId(userid);
		Product p = productRepository.findById(productId).get();
		String productName = p.getProductName(); 
		int presentQty = p.getQuantity();
		cartDetails.stream().filter(a -> a.getProductId() == productId).map(q -> q.getProductName());
		boolean check = cartDetails.stream().anyMatch(q -> q.getProductId() == productId);
		Cart c = new Cart();
		if(presentQty < quantity) {
			return null;
		}else if(check) {
			c = cartRepository.findByProductId(productId);
			c.setQuantity(c.getQuantity() + quantity);
			c.setTotalAmount((double) c.getQuantity() * p.getPrice());
			c.setProductName(productName);
		} else {
			double totalAmount = p.getPrice() * (double) quantity;
			c = new Cart(userid, productId, productName, quantity, totalAmount);
		}
		cartRepository.save(c);
		return c;
	}

	@Override
	public Cart removeFromCart(int userid, int productId, int quantity) {
		List<Cart> cartDetails = cartRepository.findByUserId(userid);
		Product p = productRepository.findById(productId).get();
		boolean check = cartDetails.stream().anyMatch(r -> r.getProductId() == productId);
		Cart c = new Cart();
		if (check) {
			c = cartRepository.findByProductId(productId);
			c.setQuantity(c.getQuantity() - quantity);
			c.setTotalAmount((double) c.getQuantity() * p.getPrice());
		} else {
			return null;
		}
		cartRepository.save(c);
		return c;
	}

	public List<Cart> getCartByUserId(int userId) {
		return cartRepository.findByUserId(userId);
	}

}
