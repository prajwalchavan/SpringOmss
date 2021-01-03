package com.project.omss.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class AdminController {

	@GetMapping("/GetAdminFunctions")
	private String UserFunction() {
		return "1. /Admin/login  \n2. /Admin/getAllUsers \n3. /Admin/{userId} \n4. /Admin/ProductAdd \n5. /getProductsByCategory \n6. /getProductByName \n7. /getProducts \n8. /Admin/updateProduct \n9. /User/PlaceOrder \n10. /Admin/ViewAllOrders \n11. /Admin/Logout";
	}

	@GetMapping("/Admin/login")
	private String AdminLogin(@RequestParam("adminId") int adminId, @RequestParam("password") String password) {
		if (adminId == 1234 && password == "admin") {
			return "Admin login Sucessful \n(/GetAdminFunctions)";
		} else {
			return "Admin Lodin Denied";
		}

	}

	@GetMapping("/Admin/Logout")
	private String AdminLogout() {
		return "--------Logged Out--------";
	}

}
