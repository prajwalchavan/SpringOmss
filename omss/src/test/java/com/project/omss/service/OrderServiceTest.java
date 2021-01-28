package com.project.omss.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.omss.entity.Order;
import com.project.omss.repository.OrderJpaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {

	@Autowired
	private OrderServiceImpl orderService;

	@MockBean
	private OrderJpaRepository orderRepo;
	
	@Test
	public void testPlaceOrder() {
		Order o = new Order();
		o.setUserId(5);
		o.setOrderDate("Januray 3, 2021");
		o.setOrderId(1001);
		o.setListOfProducts("Vicks, Crocin");
		o.setDeliveryAddress("Mumbai");
		o.setTotalAmount(200);
		o.setPayment(true);
		o.setOrderStatus("processing");
		Mockito.when(orderRepo.save(o)).thenReturn(o);
		assertNotNull(o);
	}
	
//	@Test
//	public void testGetOrderById() {
//		Order o = new Order();
//		o.setUserId(5);
//		o.setOrderDate("Januray 3, 2021");
//		o.setOrderId(1001);
//		o.setListOfProducts("Vicks, Crocin");
//		o.setDeliveryAddress("Mumbai");
//		o.setTotalAmount(200);
//		o.setPayment(true);
//		o.setOrderStatus("processing");
//		Mockito.when(orderRepo.findByUserId(5)).thenReturn(o);
//		assertThat(orderService.getOrderByUserId(5)).isEqualTo(o);
//
//	}
	
	@Test
	public void testGetAllOrders() {
		List<Order> list = new ArrayList<>();
		Mockito.when(orderRepo.findAll()).thenReturn(list);
		assertThat(orderService.getAllOrders()).isEqualTo(list);
	}
}
