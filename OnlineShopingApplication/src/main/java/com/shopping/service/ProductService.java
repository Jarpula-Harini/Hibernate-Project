package com.shopping.service;

import java.util.List;

import com.shopping.entity.Product;

public interface ProductService {
	
	public boolean createProduct(Product product);
	
	public Product getProductById(String productId);
	
	public boolean updateProduct (String productId,Product product);
	
	public boolean deleteProduct(String productId);
	
	public List<Product> getAllProducts();

	//public void getProductByOrderId(String orderId);
	
	//public Product getProductByName(String productName);
}

