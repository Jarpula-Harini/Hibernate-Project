package com.shopping.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ColumnDefault;

@Entity
public class OrderDetail {

	@Id
	int orderDetailId;
	
	int quantity;
	
	@OneToOne
	Product product;
	
	@ManyToOne
	private Orders order;

	@ColumnDefault("'A'")
	private char status;

	public OrderDetail() {
	}
	
	public OrderDetail(int orderDetailId, Product product, Orders order, int quantity, char status) {
		super();
		this.orderDetailId = orderDetailId;
		this.product = product;
		this.order = order;
		this.quantity = quantity;
		this.status = status;
	}

	public int getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

}
