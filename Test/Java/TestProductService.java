package com.shopping.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.shopping.entity.Category;
import com.shopping.entity.Product;
import com.shopping.service.ProductService;
import com.shopping.serviceimpl.ProductServiceImpl;
import com.shopping.util.HibernateUtil;

class TestProductService {

	static SessionFactory sessionFactory;
	static Session session;
	static ProductService productService;

	@BeforeAll
	static void setUp() {
		sessionFactory = HibernateUtil.getSessionFactory();

		productService = new ProductServiceImpl();
	}

	@Test
	void testcreateProduct() {

		Category category = new Category("4", "Electronics", 'A');
		Product product = new Product("1", "Smart Watch", "Digital Watch Combo BUY 1 GET 1 FREE", 899.00, "InStock",
				'A', category);
		assertTrue(productService.createProduct(product));
	}

	@Test
	void testGetProductById() {

		Product product = productService.getProductById("1");
		assertNotNull(productService.createProduct(product));
	}

	@Test
	void testUpdateProduct() {
		Category category = new Category("4", "Electronics", 'A');
		Product product = new Product("1", "LapTop", "Intel,COREi7,11TH GEN", 50000.00, "InStock", 'A', category);

		boolean updatedProduct = productService.updateProduct("1", product);
		assertTrue(updatedProduct);

	}

	@Test

	void testGetAllProducts() {

		List<Product> productList = productService.getAllProducts();
		assertNotNull(productList);

	}

	@Test
	void testDeleteProduct() {
		boolean success = productService.deleteProduct("1");
		assertTrue(success);

	}

	@AfterAll
	static void tearDown() {
		sessionFactory.close();
	}

}
