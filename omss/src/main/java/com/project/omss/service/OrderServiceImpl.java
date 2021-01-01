package com.project.omss.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.omss.entity.Cart;
import com.project.omss.entity.Order;
import com.project.omss.repository.CartJpaRepository;
import com.project.omss.repository.OrderJpaRepository;
import com.project.omss.repository.ProductJpaRepository;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	ProductJpaRepository productRepository;
	
	@Autowired
 	CartJpaRepository cartRepository;
	
	@Autowired
	OrderJpaRepository orderRepository;

	@Override
	public Order placeOrder(int userId, String deliveryAddress, boolean payment) {
		List<Cart> cartDetails = cartRepository.findByUserId(userId);
		double totalPrice = cartDetails.stream().map(p -> p.getTotalAmount()).reduce((p,q) -> p+q).get();
		String com = " , ";
		String cartOfUser = cartDetails.stream().map(Object::toString).collect(Collectors.joining(com));
		String timeStamp = LocalDate.now().toString();
		String status = "";
		if(payment) {
			status = "Order Sucessfull";
		}
		else {
			status= "Payment Pending";
		}
		Order ord = new Order(userId, timeStamp, deliveryAddress, cartOfUser, totalPrice, payment, status);
		orderRepository.save(ord);
		//cartRepository.
		return ord;
	}

}
