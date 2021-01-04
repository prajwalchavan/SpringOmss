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

/**
 * This is controller class for Products.
 * 
 * @author Prajwal
 *
 */

@RestController
public class ProductController {
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	ProductServiceImpl productService;

	/**
	 * This method is used to add products.
	 * 
	 * @param Product First parameter for the method. Accepts Products.
	 * @return product added successfully or not.
	 * @throws Exception if details are not entered correctly.
	 */

	@PostMapping("/Admin/ProductAdd")
	private String saveProduct(@Valid @RequestBody Product Product) throws Exception {
		if (Product.getProductId() > 0) {
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

	/**
	 * This method is used to view All products.
	 * 
	 * @return list of all Products with their details.
	 */

	@GetMapping("/getProducts")
	private List<Product> getAllProducts() {
		logger.info("All products Fetched");
		return productService.getAllProducts();
	}

	/**
	 * This method is used to view product by name.
	 * 
	 * @param productname First parameter for the method. Accepts product name.
	 * @return product with same name.
	 * @throws Exception if product with same name is not available.
	 */

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

	/**
	 * This method is used to view product by category.
	 * 
	 * @param category First parameter for the method. Accepts product category.
	 * @return products with same category.
	 * @throws Exception if products of this category is not available.
	 */

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

	/**
	 * This method is used to update products.
	 * 
	 * @param product First parameter for the method. Accepts product.
	 * @return product updated or not.
	 */

	@PostMapping("/Admin/updateProduct")
	public ResponseEntity<Product> updateProduct(@Valid @RequestBody Product Product) {
		Product updateProduct = productService.updateProduct(Product);
		if (Product.getCategory() != "" || Product.getProductName() != "" || Product.getCategory() != null
				|| Product.getProductName() != null || Product.getPrice() > 0 || Product.getQuantity() > 0) {
			logger.info("Products Updated");
			return new ResponseEntity<Product>(updateProduct, HttpStatus.OK);

		} else {
			logger.error("Products are not Updated");

			return new ResponseEntity("Product not Updated.", HttpStatus.NOT_MODIFIED);
		}

	}
}