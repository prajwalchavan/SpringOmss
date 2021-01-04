package com.project.omss.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is controller class for Admin.
 * 
 * @author Prajwal
 *
 */

@RestController
public class AdminController {

	Logger logger = LoggerFactory.getLogger(CartController.class);

	/**
	 * 
	 * @return This method returns all Use cases of admin.
	 */

	@GetMapping("/GetAdminFunctions")
	private String UserFunction() {
		logger.info("getting Admin functions");
		return "1. /Admin/login  \n2. /Admin/getAllUsers \n3. /Admin/{userId} \n4. /Admin/ProductAdd \n5. /getProductsByCategory \n6. /getProductByName \n7. /getProducts \n8. /Admin/updateProduct \n9. /User/PlaceOrder \n10. /Admin/ViewAllOrders \n11. /Admin/Logout";
	}

	/**
	 * This method is used to login Admin.
	 * 
	 * @param userName First parameter for the method. Accepts user name.
	 * @param password Second parameter for the method. Accepts password.
	 * @return returns if login is successful or not.
	 */

	@GetMapping("/Admin/login")
	private String AdminLogin(@RequestParam("userName") String userName, @RequestParam("password") String password) {
		if (userName == "admin" && password == "admin") {
			logger.info("Admin logged in");
			return "Admin login Successful \n(/GetAdminFunctions)";
		} else {
			logger.error("Admin login denied");
			return "Admin Login Denied";
		}
	}

	/**
	 * This method is used to logout admin.
	 * 
	 * @return returns logout statement.
	 */

	@GetMapping("/Admin/Logout")
	private String AdminLogout() {
		logger.info("Admin logged out");
		return "--------Logged Out--------";
	}

}
