package com.project.omss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.omss.repository.CartJpaRepository;
import com.project.omss.repository.OrderJpaRepository;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
 	CartJpaRepository cartRepository;
	
	@Autowired
	OrderJpaRepository orderRepository;

}
