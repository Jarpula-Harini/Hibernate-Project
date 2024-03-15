package com.shopping.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;

@Entity
public class Orders {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String orderId;

	private LocalDate orderDate;

	private double totalAmount;

	private String shippingAddress;

	private String paymentMethod;

	private String orderStatus;
	
	@ColumnDefault("'A'")
	private char status;

	@ManyToOne
	private User user;
	
	public double totalAmounts(){
		OrderDetail orderDetail = new OrderDetail();
		Product product = new Product();
		totalAmount = product.getproductPrice()*orderDetail.getQuantity();
		return totalAmount;
		}



	// Default Constructor
	public Orders() {}
	
	

	public Orders(String orderId, LocalDate orderDate, double totalAmount, String shippingAddress, String paymentMethod,
			String orderStatus, char status, User user) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.shippingAddress = shippingAddress;
		this.paymentMethod = paymentMethod;
		this.orderStatus = orderStatus;
		this.status = 'A';
		this.user = user;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

}
