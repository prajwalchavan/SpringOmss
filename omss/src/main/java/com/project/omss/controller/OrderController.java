package com.project.omss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.omss.entity.Order;
import com.project.omss.entity.User;
import com.project.omss.service.OrderServiceImpl;

@RestController
public class OrderController {
	
	@Autowired
	OrderServiceImpl orderService;
	
	@RequestMapping("/PlacrOrder")
	public Order placeOrder(@RequestParam int userId, @RequestParam String deliveryAddress, @RequestParam boolean payment) {
		return orderService.placeOrder(userId,deliveryAddress,payment);
		}
	
	@GetMapping("/ViewMyOrder")
	private Order vewMyOrder(@RequestParam("userId") int userId) {
		return orderService.getOrderByUserId(userId);
	}
	
	@GetMapping("/ViewAllOrders")
	private List<Order> getAllOrders() {
		return orderService.getAllOrders();
	}

}
