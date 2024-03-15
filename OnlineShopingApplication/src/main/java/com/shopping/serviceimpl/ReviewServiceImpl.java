package com.shopping.serviceimpl;

import java.util.List;

import com.shopping.dao.ReviewDao;
import com.shopping.service.ReviewService;
import com.shopping.daoimpl.ReviewDAOImpl;
import com.shopping.entity.Review;

public class ReviewServiceImpl implements ReviewService{
	
	ReviewDao reviewDao = new ReviewDAOImpl();

	@Override
	public boolean createReview(Review review) {
		return reviewDao.createReview(review);
		
	}

	@Override
	public Review getReviewById(String reviewId) {
		return reviewDao.getReviewById(reviewId);
		 
	}

	@Override
	public boolean updateReview(String reviewId, Review review) {
		return reviewDao.updateReview(reviewId, review);
		 
	}

	@Override
	public boolean deleteReview(String reviewId) {
		return reviewDao.deleteReview(reviewId);
		
	}

	@Override
	public List<Review> getAllReviews() {
		return reviewDao.getAllReviews();
		 
	}

	/*
	 * @Override public void getReviewByProductId(String productId) {
	 * reviewDao.getReviewByProductId(productId);
	 * 
	 * }
	 */

	
	

}
