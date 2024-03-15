package com.shopping.serviceimpl;

import java.util.List;

import com.shopping.dao.CategoryDao;
import com.shopping.service.CategoryService;
import com.shopping.daoimpl.CategoryDAOImpl;
import com.shopping.entity.Category;


public class CategoryServiceImpl implements CategoryService {
	
	CategoryDao categoryDao = new CategoryDAOImpl();
	
	
	
	public boolean createCategory(Category category) {
		
		return categoryDao.createCategory(category);
	}
	
	public Category  getCategoryById(String categoryId) {
		return categoryDao.getCategoryById(categoryId);
	}
	
	public boolean updateCategory(String categoryId,Category category) {
		
		return categoryDao.updateCategory(categoryId,category);
		
	}
	
	public boolean deleteCategory(String categoryId) {
		return categoryDao.deleteCategory(categoryId);

	}
	
	public List<Category> getAllCategory(){
		return categoryDao.getAllCategory();
	}

	/*
	 * @Override public void getCategoryByProductId(String productId) {
	 * categoryDao.getCategoryByProductId(productId);
	 * 
	 * }
	 */



	

	
	
	
	

}
