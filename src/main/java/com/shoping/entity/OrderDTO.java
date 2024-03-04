package com.shoping.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class OrderDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	@Column(name = "Order_Date")
	private LocalDateTime orderDate;
	@Column(name = "Total_Amount")
	private double totalAmount;
	@Column(name = "Shipping_Address")
	private String shippingAddress;
	@Column(name = "Payment_Method")
	private String paymentMethod;
	@Column(name = "Status")
	private String Status;

	@ManyToOne
	private UserDTO users;

	@OneToMany
	private List<ProductDTO> products = new ArrayList<>();

	// Default Constructor
	public OrderDTO() {
	}

	public OrderDTO(LocalDateTime orderDate, double totalAmount, String shippingAddress, String paymentMethod,
			String status, UserDTO users, List<ProductDTO> products) {
		super();
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.shippingAddress = shippingAddress;
		this.paymentMethod = paymentMethod;
		Status = status;
		this.users = users;
		this.products = products;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
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

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public UserDTO getUsers() {
		return users;
	}

	public void setUsers(UserDTO users) {
		this.users = users;
	}

	public List<ProductDTO> getProducts() {
		return products;
	}

	public void setProducts(List<ProductDTO> products) {
		this.products = products;
	}

}
