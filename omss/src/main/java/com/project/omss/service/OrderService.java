package com.project.omss.service;

import com.project.omss.entity.Order;

public interface OrderService {
	
	Order placeOrder(int userId, String deliveryAddress, boolean payment);

}
