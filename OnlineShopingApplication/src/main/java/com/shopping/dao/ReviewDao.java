package com.shopping.dao;

import java.util.List;

import com.shopping.entity.Review;



public interface ReviewDao {
	
	public boolean createReview (Review review);
	
	public  Review getReviewById(String reviewId);
	
	public boolean updateReview(String reviewId,Review review);
	
	public boolean deleteReview (String reviewId);
	
	public List<Review> getAllReviews ();
	
	//public Review getReviewByProductId(String productId);

	
	
}
