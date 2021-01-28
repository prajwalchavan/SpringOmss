//package com.project.omss.repository;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.project.omss.entity.Order;
//
//@RunWith(SpringRunner.class)
//@AutoConfigureTestDatabase(replace= Replace.NONE)
//@DataJpaTest
//
//public class OrderJpaRepositoryTest {
//	
//	@Autowired
//	private TestEntityManager entityManager;
//	
//	@Autowired
//	private OrderJpaRepository orderRepo;
//	
//	@Test
//	public void testGetByUserId() 
//	{
//		Order o = new Order();
//		o.setUserId(5);
//		o.setOrderDate("Januray 3, 2021");
//		o.setListOfProducts("Vicks, Crocin");
//		o.setDeliveryAddress("Mumbai");
//		o.setTotalAmount(200);
//		o.setPayment(true);
//		o.setOrderStatus("processing");
//		Order savedInDb=entityManager.persist(o);
//		Order getFromDb=orderRepo.findByUserId(savedInDb.getUserId());
//		
//		assertThat(getFromDb).isEqualTo(getFromDb);
//	}
//	
//	}
