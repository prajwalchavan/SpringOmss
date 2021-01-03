package com.project.omss.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	ProductServiceImpl productService;

	@PostMapping("/Admin/ProductAdd")
	private String saveProduct(@Valid @RequestBody Product Product) throws Exception {
		if (Product.getProductId() != 0 && Product.getProductId() > 0) {
			if (Product.getCategory() != "" && Product.getProductName() != "" && Product.getCategory() != null
					&& Product.getProductName() != null && Product.getPrice() > 0 && Product.getQuantity() > 0) {
				logger.info("Product Added");
				return Product.getProductId() + " " + productService.saveOrUpdate(Product);
			} else {
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
		logger.info("All products Fetched");
		return productService.getAllProducts();
	}

	// Find by Name
	@RequestMapping("/getProductByName")
	private List<Product> getProductByName(@RequestParam("productname") String productname) throws Exception {
		if (productname != null && productname != "") {
			logger.info("products Fetched by name");
			return productService.getProductByName(productname);
		} else {
			logger.error("Exception Occured!!! PRODUCT Name has incorrect data");
			throw new APIException("INVALID Product Name");
		}
	}

	// Find by Category
	@RequestMapping("/getProductsByCategory")
	private List<Product> getProductByCategory(@RequestParam("category") String category) throws Exception {
		if (category != null && category != "") {
			logger.info("products Fetched by name");
			return productService.getProductByCategory(category);
		} else {
			logger.error("Exception Occured!!! PRODUCT Category has incorrect data");
			throw new APIException("INVALID Product Category");
		}
	}

	// Updating a product

	@PostMapping("/Admin/updateProduct")
	public ResponseEntity<Product> updateProduct(@Valid @RequestBody Product product) {
		Product updateProduct = productService.updateProduct(product);
		if (updateProduct == null) {
			return new ResponseEntity("Product not Updated.", HttpStatus.NOT_MODIFIED);
		}
		return new ResponseEntity<Product>(updateProduct, HttpStatus.OK);
	}
}