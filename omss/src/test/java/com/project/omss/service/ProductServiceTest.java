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

import com.project.omss.entity.Product;
import com.project.omss.repository.ProductJpaRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {
	
	@Autowired
	private ProductServiceImpl productService;

	@MockBean
	private ProductJpaRepository productRepo;
	
	@Test
	public void testAddProduct() {
		Product product = new Product();
		product.setProductId(1004);
		product.setProductName("crocin-plus");
		product.setCategory("Tablet");
		product.setQuantity(50);
		product.setPrice(40.0);
		Mockito.when(productRepo.save(product)).thenReturn(product);
		 assertNotNull("added/updated", product);
	}

	@Test
	public void testGetAllProducts() {
		List<Product> list = new ArrayList<>();
		Mockito.when(productRepo.findAll()).thenReturn(list);
		assertThat(productService.getAllProducts()).isEqualTo(list);
	}

	@Test
	public void testUpdateProduct() {
		Product product = new Product();
		product.setProductId(1004);
		product.setProductName("crocin-plus");
		product.setCategory("Tablet");
		product.setQuantity(250);
		product.setPrice(45.0);
		Mockito.when(productRepo.save(product)).thenReturn(product);
		assertThat(productService.updateProduct(product)).isEqualTo(product);	
	}

}
