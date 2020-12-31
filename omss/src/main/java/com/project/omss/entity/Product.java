package com.project.omss.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="product_table")
public class Product {
	@Id
	@Column(name="productId")
	private int productId;
	@Column(name="productName")
	private String productName;
	@Column(name="category")
	private String category;
	@Column(name="quantity")
	private int quantity;
	@Column(name="price")
	private double price;
	
	@ManyToMany
	@JoinTable(name="products_in_cart",joinColumns=@JoinColumn(name="productId"),inverseJoinColumns=@JoinColumn(name="cartId")) 
	private List<Cart> carts = new ArrayList<>();
	
	
	
	public Product() {
		super();
	}
	public Product(int productId, String productName, String category, int quantity, double price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.category = category;
		this.quantity = quantity;
		this.price = price;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public List<Cart> getCarts() {
		return carts;
	}
	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", category=" + category
				+ ", quantity=" + quantity + ", price=" + price + "]";
	}
	
	
}
