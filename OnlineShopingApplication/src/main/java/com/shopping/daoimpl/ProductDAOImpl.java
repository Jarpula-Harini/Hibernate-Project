package com.shopping.daoimpl;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.shopping.dao.ProductDao;
import com.shopping.entity.Product;
import com.shopping.util.HibernateUtil;

public class ProductDAOImpl implements ProductDao {
	
	public boolean createProduct(Product product) {
		
		try (Session session=HibernateUtil.getSession()){
			
			session.beginTransaction();
			session.save(product);
			session.getTransaction().commit();
			session.clear();
			
			return true;
			
			}catch(HibernateException ex) {
			System.out.println("Hibernate Exception:" + ex);
		}catch(Exception e) {
			System.out.println("Exception:" + e);
		}
		return false;
		
		
		}//
	
	
	public Product getProductById(String productId) {
		try (Session session=HibernateUtil.getSession()){

			Product product = session.get(Product.class, productId);

			return product;
		} catch (HibernateException e) {
			System.out.println("HibernateException:" + e);
		} catch (Exception ex) {
			System.out.println("Exception:" + ex);

		}

		return null;
	}//
	
	public boolean updateProduct (String productId,Product product) {
		try (Session session=HibernateUtil.getSession()){
			session.beginTransaction();

			 Product existProduct = session.load( Product.class,  productId);

			existProduct.setProductName(product.getProductName());
			existProduct.setDescription(product.getDescription());
			existProduct.setproductPrice(product.getproductPrice());
            existProduct.setProductInStock(product.getProductInStock());
            existProduct.setCategory(product.getCategory());
			
			
			session.saveOrUpdate(existProduct);
			session.getTransaction().commit();
			return true;

		} catch (HibernateException e) {
			System.out.println("HibernateException:" + e);
		} catch (Exception ex) {
			System.out.println("Exception:" + ex);

		}
		return false;
	}//
	
	public boolean deleteProduct(String productId) {
   try (Session session=HibernateUtil.getSession()){
			
	     Product product = session.get(Product.class, productId);
			session.beginTransaction();
			if (product != null) {
				product.setStatus('I');
				session.saveOrUpdate(product);
				session.getTransaction().commit();
				
				return true;
			} else {
				System.out.println("Product details not found!!");
			}
			

		} catch (HibernateException e) {
			System.out.println("Hibernate exception is: " + e);
		} catch (Exception e) {
			System.out.println("Exception is: " + e);
		}
   
   return false;
	}//
	
	public List<Product> getAllProducts(){
		Session session = HibernateUtil.getSession();
		
		List<Product> productList = session.createQuery("from Product", Product.class).getResultList();
		return productList;
	}





	/*
	 * @Override public Product getProductByOrderId(String orderId) { try (Session
	 * session=HibernateUtil.getSession()){
	 * 
	 * Product product = session.get(Product.class, orderId);
	 * 
	 * return product; } catch (HibernateException e) {
	 * System.out.println("HibernateException:" + e); } catch (Exception ex) {
	 * System.out.println("Exception:" + ex);
	 * 
	 * }
	 * 
	 * return null;
	 * 
	 * }
	 */
	}
	


