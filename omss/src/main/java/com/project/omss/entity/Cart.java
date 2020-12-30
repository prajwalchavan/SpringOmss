package com.project.omss.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "CartDetails")
public class Cart {
	@Id
	@Column(name = "cart_id")
	private int cartId;
	@Column(name = "user_id")
	private int userid;
	@Column(name = "Quantity")
	private int quantity;
	@Column(name = "Total_Amount")
	private double totalAmount;
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
	public Cart(int cartId, int userid, int quantity, double totalAmount) {
		super();
		this.cartId = cartId;
		this.userid = userid;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
	}
	public Cart() {
		super();
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", userid=" + userid + ", quantity=" + quantity
				+ ", totalAmount=" + totalAmount + "]";
	}

	
}
