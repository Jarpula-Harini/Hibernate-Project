package com.shopping.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;

@Entity
public class Category {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String categoryId;

	private String categoryName;

	

	@ColumnDefault("'A'")
	private char status;

	// Default Constructor
	public Category() {
	}
	

	public Category(String categoryId, String categoryName,char status) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.status = 'A';
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

}
