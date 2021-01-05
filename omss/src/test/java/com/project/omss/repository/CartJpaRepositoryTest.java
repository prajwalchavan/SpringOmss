package com.project.omss.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.omss.entity.Cart;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace= Replace.NONE)
@DataJpaTest
@TestMethodOrder(OrderAnnotation.class)
public class CartJpaRepositoryTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private CartJpaRepository  cartJpaRepository ;
	
	@Test
	public void testCartByProductId() 
	{
		Cart cart =new Cart();
		Cart savedInDb=entityManager.persist(cart);
		Cart getFromDb=cartJpaRepository.findByProductId(savedInDb.getProductId());
		
		assertThat(getFromDb).isEqualTo(savedInDb);
		
	}
	
	@Test
	public void testAddToCart() 
	{
		Cart cart =new Cart();
		cart.setUserid(1);
		cart.setProductId(101);
		cart.setProductName("vicks");
		cart.setQuantity(2);
		cart.setTotalAmount(30);
		Cart savedInDB=entityManager.persist(cart);
		Cart cartDetails= cartJpaRepository.findByProductId(savedInDB.getProductId());
		
		assertThat(cartDetails).isEqualTo(savedInDB);
	}
	
	@Test
	public void testDeleteFromCart() 
	{
		Cart cart =new Cart();
		cart.setUserid(1);
		cart.setProductId(101);
		cart.setProductName("vicks");
		cart.setQuantity(2);
		cart.setTotalAmount(30);
		Cart persist = entityManager.persist(cart);
		
		//delete 
		entityManager.remove(persist);
		Iterable<Cart> cartDetailsFromDb = cartJpaRepository.findAll();
		List<Cart> cartList = new ArrayList<>();
		
		for (Cart ticket : cartDetailsFromDb ) {
			cartList.add(ticket);
		}
		assertThat(cartList.size()).isGreaterThan(0);
	}

}
