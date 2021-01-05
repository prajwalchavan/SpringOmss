package com.project.omss.repository;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.omss.entity.Product;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace= Replace.NONE)
@DataJpaTest
public class ProductJpaRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired 
	private ProductJpaRepository productRepo;
	
		public Product getProduct() {
		Product p = new Product();
		p.setProductId(1004);
		p.setProductName("crocin-plus");
		p.setCategory("Tablet");
		p.setQuantity(50);
		p.setPrice(40.0);
		entityManager.persist(p);
		return p;
	}
	
	@Test
	public void testGetByName() {
		Product p =getProduct();
		List<Product> getByName = productRepo.findByProductName(p.getProductName());
		assertNotNull(getByName);
	}
	
	@Test
	public void testGetByCategory() {
		Product p =getProduct();
		List<Product> getByCategory = productRepo.findByCategory(p.getCategory());
		assertNotNull(getByCategory);
	}

}
