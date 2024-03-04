package com.crud.operation;

import java.util.List;

import com.shoping.entity.ProductDTO;
import com.shoping.entity.ReviewDTO;

public interface ProductDao {

	public void saveProduct(ProductDTO product);
	public ProductDTO getProductById(int productId);
	List<ProductDTO> getAllProducts();
	List<ProductDTO> getProductByReview(ReviewDTO review);
	public void updateProduct (ProductDTO product);
	public void deleteProduct(int productId);
	
}
