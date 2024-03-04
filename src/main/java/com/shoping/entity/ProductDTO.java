package com.shoping.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ProductDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	@Column(name = "Product_Name")
	private String productName;
	@Column(name = "Description")
	private String Description;
	@Column(name = "Price")
	private double Price;
	@Column(name = "Product_InStock")
	private String productInStock;

	@ManyToOne
	private CategoryDTO category;

	// Default Constructor
	public ProductDTO() {
	}

	public ProductDTO(String productName, String description, double price, String productInStock,
			CategoryDTO category) {
		super();
		this.productName = productName;
		Description = description;
		Price = price;
		this.productInStock = productInStock;
		this.category = category;
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

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public String getProductInStock() {
		return productInStock;
	}

	public void setProductInStock(String productInStock) {
		this.productInStock = productInStock;
	}

	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}

}
