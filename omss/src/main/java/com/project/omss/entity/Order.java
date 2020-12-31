package com.project.omss.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_table")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderId")
	private int orderId;
	@Column(name = "userId")
	private String userId;
	@Column(name = "orderDate")
	private String orderDate;
	@Column(name = "deliveryAddress")
	private String deliveryAddress;
	@Column(name = "payment")
	boolean payment;
	@Column(name = "orderStatus")
	private String orderStatus;

	public Order() {
		super();
	}

	public Order(String userId, String orderDate, String deliveryAddress, boolean payment, String orderStatus) {
		super();
		this.userId = userId;
		this.orderDate = orderDate;
		this.deliveryAddress = deliveryAddress;
		this.payment = payment;
		this.orderStatus = orderStatus;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public boolean isPayment() {
		return payment;
	}

	public void setPayment(boolean payment) {
		this.payment = payment;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", orderDate=" + orderDate + ", deliveryAddress="
				+ deliveryAddress + ", payment=" + payment + ", orderStatus=" + orderStatus + "]";
	}

}
