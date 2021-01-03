package com.project.omss.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	public static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	OrderServiceImpl orderService;
	
	@RequestMapping("/User/PlaceOrder")
	public Order placeOrder(@Valid @RequestParam int userId,@Valid @RequestParam String deliveryAddress,
			@Valid @RequestParam boolean payment) throws Exception {
		if (userId > 0 && deliveryAddress != null && deliveryAddress != "") {
			logger.info("Order Placed Sucessfully");
			return orderService.placeOrder(userId, deliveryAddress, payment);
		} else
			logger.error("Order not placed! Please Check your details to place order");
			throw new USERException("Error Occured!!! Please Check your details to place order");
	}

	@GetMapping("/User/ViewMyOrders")
	private Order vewMyOrder(@RequestParam("userId") int userId) throws Exception{
		if (userId > 0) {
			logger.info("Order fetched for given User ID");
			return orderService.getOrderByUserId(userId);
	} else
			logger.error("Cannot fetch Order! Please Check userId to proceed");
			throw new USERException("Error Occured!!!Please Check userId to proceed");
	}

	@GetMapping("/Admin/ViewAllOrders")
	private List<Order> getAllOrders() {
		logger.info("Fetched All orders");
		return orderService.getAllOrders();
	}

}
