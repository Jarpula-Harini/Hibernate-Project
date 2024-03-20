package com.shopping.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.shopping.dao.ReviewDao;
import com.shopping.entity.Review;
import com.shopping.util.HibernateUtil;

public class ReviewDAOImpl implements ReviewDao {

	public boolean createReview(Review reviews) {

		try (Session session = HibernateUtil.getSession()) {

			session.beginTransaction();
			session.save(reviews);
			session.getTransaction().commit();

			return true;

		} catch (HibernateException e) {
			System.out.println("Hibernate Exception:" + e);

		} catch (Exception e) {
			System.out.println("Exception:" + e);
		}
		return false;

	}//

	public Review getReviewById(String reviewId) {
		try (Session session = HibernateUtil.getSession()) {

			Review reviews = session.get(Review.class, reviewId);

			return reviews;
		} catch (HibernateException e) {
			System.out.println("HibernateException:" + e);
		} catch (Exception ex) {
			System.out.println("Exception:" + ex);

		}

		return null;
	}//

	public boolean updateReview(String reviewId, Review review) {

		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();

			Review existReview = session.load(Review.class, reviewId);

			existReview.setRating(review.getRating());
			existReview.setComments(review.getComments());
			existReview.setUser(review.getUser());

			session.saveOrUpdate(existReview);
			session.getTransaction().commit();
			return true;

		} catch (HibernateException e) {
			System.out.println("HibernateException:" + e);
		} catch (Exception ex) {
			System.out.println("Exception:" + ex);

		}
		return false;
	}//

	public boolean deleteReview(String reviewId) {
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();

			Review review = session.get(Review.class, reviewId);
			
			if (review != null) {
				review.setStatus('I');
				
				session.saveOrUpdate(review);
				session.getTransaction().commit();

				return true;

			} else {
				System.out.println("Review details not found!!");
			}

		} catch (HibernateException e) {
			System.out.println("Hibernate exception is: " + e);
		} catch (Exception e) {
			System.out.println("Exception is: " + e);
		}
		return false;
	}//

	public List<Review> getAllReviews() {
		Session session = HibernateUtil.getSession();

		List<Review> reviewList = session.createQuery("from Review", Review.class).getResultList();
		return reviewList;
	}

	/*
	 * @Override public Review getReviewByProductId(String productId) { try (Session
	 * session=HibernateUtil.getSession()){
	 * 
	 * Review reviews = session.get(Review.class, productId);
	 * 
	 * return reviews; } catch (HibernateException e) {
	 * System.out.println("HibernateException:" + e); } catch (Exception ex) {
	 * System.out.println("Exception:" + ex);
	 * 
	 * }
	 * 
	 * return null; }
	 */

}
