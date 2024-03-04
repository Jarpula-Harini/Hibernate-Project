package com.shoping.ImplDao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.shoping.entity.ProductDTO;

public class ProductDAO {
	
	private final SessionFactory sessionFactory ;
	
	public ProductDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void createProduct(ProductDTO product) {
		
		try(Session session = sessionFactory.openSession()){
			Transaction tnx = session.beginTransaction();
			
			session.save(product);
			
			tnx.commit();
			
		}
		
	}
	

}
