package com.project.omss.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.omss.entity.Order;
import com.project.omss.exception.USERException;
import com.project.omss.service.OrderServiceImpl;

@RestController
public class OrderController {
	
	@Autowired
	OrderServiceImpl orderService;
	
	@RequestMapping("/PlaceOrder")
	public Order placeOrder(@Valid @RequestParam int userId,@Valid @RequestParam String deliveryAddress,
			@Valid @RequestParam boolean payment) throws Exception {
		if (userId > 0 && deliveryAddress != null && deliveryAddress != "")
			return orderService.placeOrder(userId, deliveryAddress, payment);
		else
			throw new USERException("Error Occured!!! Please Check your details to place order");
	}

	@GetMapping("/ViewMyOrder")
	private Order vewMyOrder(@RequestParam("userId") int userId) throws Exception{
		if (userId > 0)
			return orderService.getOrderByUserId(userId);
		else
			throw new USERException("Error Occured!!!Please Check userId to proceed");
	}

	@GetMapping("/ViewAllOrders")
	private List<Order> getAllOrders() {
		return orderService.getAllOrders();
	}

}
