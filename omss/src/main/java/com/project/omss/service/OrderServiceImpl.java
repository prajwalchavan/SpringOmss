package com.project.omss.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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
		String com = " , ";
		String cartOfUser = cartDetails.stream().map(Object::toString).collect(Collectors.joining(com));
		Order o = new Order();
		o.setListOfProducts(cartOfUser);
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		o.setOrderDate(timeStamp);
		//cartDetails.forEach();
		double price = 500;
		o.setTotalAmount(price);
		if(payment) {
			o.setOrderStatus("Order Sucessfull");;
		}
		else {
			o.setOrderStatus("Payment Pending");
		}
		orderRepository.save(o);
		return o;
	}

}
