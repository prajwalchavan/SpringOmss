package com.project.omss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.omss.entity.Order;
import com.project.omss.service.OrderServiceImpl;

@RestController
public class OrderController {
	
	@Autowired
	OrderServiceImpl orderService;
	
	@PostMapping("/PlacrOrder")
	public Order placeOrder(@RequestParam int userId, @RequestParam String deliveryAddress, @RequestParam boolean payment) {
		return orderService.placeOrder(userId,deliveryAddress,payment);
		}

}
