package com.project.omss.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.omss.entity.Order;
import com.project.omss.repository.OrderJpaRepository;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace= Replace.NONE)
@DataJpaTest

public class OrderJpaRepositoryTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private OrderJpaRepository orderRepo;
	
	@Test
	public void testGetByUserId() 
	{
		Order o = new Order();
		Order savedInDb=entityManager.persist(o);
		Order getFromDb=orderRepo.findByUserId(savedInDb.getUserId());
		
		assertThat(getFromDb).isEqualTo(getFromDb);
	}
	
	}
