package com.shopping.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.shopping.dao.CategoryDao;
import com.shopping.entity.Category;
import com.shopping.util.HibernateUtil;

public class CategoryDAOImpl implements CategoryDao {

	
	public boolean createCategory(Category category) {

		try (Session session=HibernateUtil.getSession()){
			session.beginTransaction();
			session.save(category);
			session.getTransaction().commit();
			session.clear();

			return true;
		} catch (HibernateException ex) {

			System.out.println("HibernateException:" + ex);
		} catch (Exception e) {
			System.out.println("Exception:" + e);
		}
		return false;
	}//

	public Category getCategoryById(String categoryId) {
		try (Session session=HibernateUtil.getSession()){

			Category category = session.get(Category.class, categoryId);

			return category;
		} catch (HibernateException e) {
			System.out.println("HibernateException:" + e);
		} catch (Exception ex) {
			System.out.println("Exception:" + ex);

		}

		return null;
	}

	public  boolean updateCategory(String categoryId, Category category) {
		try (Session session=HibernateUtil.getSession()){

			Category existCategory = session.load(Category.class, categoryId);

			existCategory.setCategoryName(category.getCategoryName());
			

			session.beginTransaction();
			session.saveOrUpdate(existCategory);
			session.getTransaction().commit();
			return true;

		} catch (HibernateException e) {
			System.out.println("HibernateException:" + e);
		} catch (Exception ex) {
			System.out.println("Exception:" + ex);

		}
		return false;
	}//

	public boolean deleteCategory(String categoryId) {
		try (Session session=HibernateUtil.getSession()){
			
			Category category = session.get(Category.class, categoryId);
			session.beginTransaction();
			if (category != null) {
				session.delete(category);
				
				return true;
			} else {
				System.out.println("Category details not found!!");
			}

		} catch (HibernateException e) {
			System.out.println("Hibernate exception is: " + e);
		} catch (Exception e) {
			System.out.println("Exception is: " + e);
		}
		return false;
	}//

	public List<Category> getAllCategory() {
		Session session = HibernateUtil.getSession();
	
		List<Category> categoryList = session.createQuery("from Category", Category.class).getResultList();
		return categoryList;
	}

/*	@Override
	public Category getCategoryByProductId(String productId) {
		try (Session session=HibernateUtil.getSession()){

			Category category = session.get(Category.class, productId);

			return category ;
		} catch (HibernateException e) {
			System.out.println("HibernateException:" + e);
		} catch (Exception ex) {
			System.out.println("Exception:" + ex);

		}

		return null;
		
		
		
	}*/

	
	

	


}
