package com.shopping.dao;

import java.util.List;

import com.shopping.entity.Product;


public interface ProductDao {

	public boolean createProduct(Product product);
	
	public Product getProductById(String productId);
	
	public boolean updateProduct (String productId,Product product);
	
	public boolean deleteProduct(String productId);
	
	public List<Product> getAllProducts();
	
	//public Product getProductByOrderId(String orderId);
	
	
	
}
