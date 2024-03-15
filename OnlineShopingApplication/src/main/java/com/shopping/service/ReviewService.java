package com.shopping.service;

import java.util.List;

import com.shopping.entity.Review;


public interface ReviewService {
	
	public boolean createReview (Review review);
	
	public Review getReviewById(String reviewId);
	
	public boolean updateReview(String reviewId,Review review);
	
	public boolean deleteReview (String reviewId);
	
	public List<Review> getAllReviews ();
	
	//public void getReviewByProductId(String productId);


}
