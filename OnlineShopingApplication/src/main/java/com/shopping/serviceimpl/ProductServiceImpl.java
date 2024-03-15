package com.shopping.serviceimpl;

import java.util.List;

import com.shopping.dao.ProductDao;
import com.shopping.daoimpl.ProductDAOImpl;
import com.shopping.entity.Product;
import com.shopping.service.ProductService;

public class ProductServiceImpl implements ProductService {
	
	ProductDao productDao = new ProductDAOImpl();
	
	
	public boolean createProduct(Product product) {
		return productDao.createProduct(product);
	}
	
	public Product getProductById(String productId) {
		return productDao.getProductById(productId);
	}
	
	public boolean updateProduct (String productId,Product product) {
		return productDao.updateProduct(productId, product);
	}
	
	public boolean deleteProduct(String productId) {
		return productDao.deleteProduct(productId);
	}
	
	public List<Product> getAllProducts(){
		return productDao.getAllProducts();
	}

	/*
	 * @Override public void getProductByOrderId(String orderId) { // TODO
	 * Auto-generated method stub
	 * 
	 * }
	 * 
	 * @Override public Product getProductByName(String productName) { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * 
	 * @Override public void getProductByOrderId(String orderId) {
	 * productDao.getProductByOrderId(orderId); }
	 * 
	 * 
	 * 
	 * @Override public Product getProductByName(String productName) { productDao.ge
	 * 
	 * }
	 */
	 

	
	
}
