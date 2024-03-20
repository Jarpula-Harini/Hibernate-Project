package com.shopping.test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.shopping.entity.Review;
import com.shopping.entity.User;
import com.shopping.service.ReviewService;
import com.shopping.serviceimpl.ReviewServiceImpl;
import com.shopping.util.HibernateUtil;

class TestReviewService {

	static SessionFactory sessionFactory;
	static Session session;
	static ReviewService reviewService;

	@BeforeAll
	static void setUp() {
		sessionFactory = HibernateUtil.getSessionFactory();

		reviewService = new ReviewServiceImpl();
	}
	
	@Test
	void testCreateOrder() {
 
		User user = new User("102", "Virat", "virat@123", "Pune", 958594390, 'A');
		Review review = new Review("2", 4.2, "Material quality is not good don't buy this dress ",'A',user);
		
		assertTrue(reviewService.createReview(review));
	}
	

	@Test
	void testGetUserById() {

		Review review = reviewService.getReviewById("1");
		assertNotNull(reviewService.createReview(review));

	} 

	@Test
	void testUpdateUser() {
		User user = new User("1", "Jhon", "john@234", "Delhi", 7855648, 'A');
		Review review = new Review("2", 4.0, "I have recived diffrent product",'A',user);

		boolean updatedReview = reviewService.updateReview("2", review);
		assertTrue(updatedReview);

	}

	@Test

	void testGetAllReviews() {

		List<Review> reviewList = reviewService.getAllReviews();
		assertNotNull(reviewList);

	}

	@Test
	void testDeleteReview() {
		boolean success = reviewService.deleteReview("1");
		assertTrue(success);
	
	} 
	
	@AfterAll
	static void tearDown() {
		sessionFactory.close();
	}


	

}
