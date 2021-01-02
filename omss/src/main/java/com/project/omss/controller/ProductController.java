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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
public class ProductController {
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	ProductServiceImpl productService;

	@PostMapping("/ProductAdd")
	private String saveProduct(@RequestBody Product Product) throws Exception {
		if (Product.getProductId() != 0 && Product.getProductId() > 0) {
			if (Product.getCategory() != "" && Product.getProductName() != "" && Product.getCategory() != null
					&& Product.getProductName() != null && Product.getPrice() > 0 && Product.getQuantity() > 0)
				return Product.getProductId() + " " + productService.saveOrUpdate(Product);
			else {
				logger.error("Exception Occured!!! PRODUCT field has incoreect data");
				throw new APIException(" Exception Occured!!!INVALID PRODUCT DETAILS!!!Please Check Product Details.");
			}
		} else {
			logger.error("Exception Occured!!! PRODUCT field has incorrect data");
			throw new APIException(" Exception Occured!!!INVALID PRODUCT ID!!!Please check Product ID");
		}

	}

	@GetMapping("/getProducts")
	private List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	// Find by Name
	@RequestMapping("/getByName")
	private List<Product> getProductByName(@RequestParam("productname") String productname) throws Exception {
		if (productname != null && productname != "")
			return productService.getProductByName(productname);
		else {
			logger.error("Exception Occured!!! PRODUCT Name has incorrect data");
			throw new APIException("INVALID Product Name");
		}
	}

	// Find by Category
	@RequestMapping("/getByCategory")
	private List<Product> getProductByCategory(@RequestParam("category") String category) throws Exception {
		if (category != null && category != "")
			return productService.getProductByCategory(category);
		else {
			logger.error("Exception Occured!!! PRODUCT Category has incorrect data");
			throw new APIException("INVALID Product Category");
		}
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