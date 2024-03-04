package com.shoping.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CategoryDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryId;
	@Column(name = "category_Name")
	private String categoryName;
	@Column(name = "description")
	private String description;
	
	
	@OneToMany
	private List<ProductDTO>product = new ArrayList<>();
	

	// Default Constructor
	public CategoryDTO() {
	}

}
