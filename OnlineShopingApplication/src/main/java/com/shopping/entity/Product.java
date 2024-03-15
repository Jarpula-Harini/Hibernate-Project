package com.shopping.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;

@Entity
public class Product {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String productId;

	private String productName; // soap

	private String description;

	private double productPrice;

	private String productInStock;
	
	@ColumnDefault("'A'")
	private char status;

	@ManyToOne
	private Category category;

	// Default Constructor
	public Product() {}

	public Product(String productId, String productName, String description, double productPrice, String productInStock,
			char status, Category category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.productPrice = productPrice;
		this.productInStock = productInStock;
		this.status = status;
		this.category = category;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getproductPrice() {
		return productPrice;
	}

	public void setproductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductInStock() {
		return productInStock;
	}

	public void setProductInStock(String productInStock) {
		this.productInStock = productInStock;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	

	
}
