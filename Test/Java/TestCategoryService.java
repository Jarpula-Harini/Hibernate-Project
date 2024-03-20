package com.shopping.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.shopping.entity.Category;
import com.shopping.service.CategoryService;
import com.shopping.serviceimpl.CategoryServiceImpl;
import com.shopping.util.HibernateUtil;

class TestCategoryService {
	static SessionFactory sessionFactory;
	static Session session;
	static CategoryService categoryService;

	@BeforeAll
	static void setUp() {
		sessionFactory = HibernateUtil.getSessionFactory();

		categoryService = new CategoryServiceImpl();
	}

	@Test
	void testcreateCategory() {

		Category testCategory = new Category("5", "Kids&Toys",'A');
		assertTrue(categoryService.createCategory(testCategory));
	

		Category testCategory1 = new Category("2", "Bags&FootWear",'A');
		assertTrue(categoryService.createCategory(testCategory1));

		Category testCategory2 = new Category("3", "Kurti,Saree&Lehenga",'A');
		assertTrue(categoryService.createCategory(testCategory2)); 
		
		Category category = new Category("4","Electronics",'A');
		assertTrue(categoryService.createCategory(category));
		
	} 

	@Test
	void testGetCategoryById() {

		Category categories = categoryService.getCategoryById("1");
		assertNotNull(categoryService.createCategory(categories));

	}

	@Test
	void testUpdateCategory() {
		Category categories = new Category("2", "KidsWear",'A');

		boolean updatedUsers = categoryService.updateCategory("2", categories);
		assertTrue(updatedUsers);

	}

	@Test

	void testGetAllCategory() {

		List<Category> categoryList = categoryService.getAllCategory();
		assertNotNull(categoryList);

	}

	@Test
	void testDeleteCategory() {
		boolean success = categoryService.deleteCategory("1");
		assertTrue(success);
		
	} 
	
	@AfterAll
	static void tearDown() {
		sessionFactory.close();
	}



}
