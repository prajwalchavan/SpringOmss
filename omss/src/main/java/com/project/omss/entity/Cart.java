package com.project.omss.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity

@Table(name = "CartDetails")
public class Cart {
	@Id
	@Column(name = "cart_id")
	private int cartId;
	@Column(name = "user_id")
	private int userid;
	@Column(name= "product_id")
	private int productId;
	@Column(name = "Quantity")
	private int quantity;
	@Column(name = "Total_Amount")
	private double totalAmount;
	
	@ManyToMany(mappedBy="carts" )
	private List<Product> Products = new ArrayList<>();
	
	
	
	public Cart() {
		super();
	}
	public Cart(int cartId, int userid, int productId, int quantity, double totalAmount) {
		super();
		this.cartId = cartId;
		this.userid = userid;
		this.productId = productId;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public List<Product> getProducts() {
		return Products;
	}
	public void setProducts(List<Product> products) {
		Products = products;
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", userid=" + userid + ", productId=" + productId + ", quantity=" + quantity
				+ ", totalAmount=" + totalAmount + "]";
	}
	
	
}
