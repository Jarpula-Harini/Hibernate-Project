
package com.shopping.service;

import java.util.List;

import com.shopping.entity.Category;


public interface CategoryService {
	
	public boolean createCategory(Category category);
	
	public Category getCategoryById(String categoryId);
	
	public boolean updateCategory(String categoryId,Category category);
	
	public boolean deleteCategory(String categoryId);
	
	public List<Category> getAllCategory();
	
	//public void getCategoryByProductId(String productId);
	
	

}
