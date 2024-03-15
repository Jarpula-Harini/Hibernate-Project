package com.shopping.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Positive;

import org.hibernate.annotations.ColumnDefault;

@Entity
public class Review {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)

	private String reviewId;

	@Positive(message = "Invalid rating. Value should be positive.")
	private double rating;

	private String comments;

	@ColumnDefault("'A'")
	private char status;

	@ManyToOne
	private User user;

	// Default Constructor
	public Review() {
	}

	public Review(String reviewId, double rating,String comments, char status, User user) {
		super();
		this.reviewId = reviewId;
		this.rating = rating;
		this.comments = comments;
		this.status = status;
		this.user = user;
	}

	public String getReviewId() {
		return reviewId;
	}

	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
