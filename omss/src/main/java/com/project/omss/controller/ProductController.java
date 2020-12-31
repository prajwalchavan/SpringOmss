package com.project.omss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.omss.entity.Product;
import com.project.omss.exception.APIException;
import com.project.omss.service.ProductServiceImpl;

@RestController
public class ProductController {

	@Autowired
	ProductServiceImpl productService;

	@PostMapping("/ProductAdd")
	private String saveProduct(@RequestBody Product Product) throws Exception{
	if(Product.getProductId()!=0)	
		return Product.getProductId() + " " + productService.saveOrUpdate(Product);
	else
		throw new APIException(" Exception Occured!!! Please Check Product Field Data");
	
	}

	@GetMapping("/getProducts")
	private List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	// Find by Name
	@RequestMapping("/getByName")
	private List<Product> getProductByName(@RequestParam("productname") String productname) {
		return productService.getProductByName(productname);
	}

	// Find by Category
	@RequestMapping("/getByCategory")
	private List<Product> getProductByCategory(@RequestParam("category") String category) {
		return productService.getProductByCategory(category);
	}

	// Updating a product

	@PostMapping("/update")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		Product updateProduct = productService.updateProduct(product);
		if (updateProduct == null) {
			return new ResponseEntity("Product not Updated.", HttpStatus.NOT_MODIFIED);
		}
		return new ResponseEntity<Product>(updateProduct, HttpStatus.OK);
	}
}
