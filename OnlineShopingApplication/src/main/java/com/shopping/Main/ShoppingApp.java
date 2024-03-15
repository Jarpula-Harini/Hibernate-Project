package com.shopping.Main;

import java.time.LocalDate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.shopping.entity.Category;
import com.shopping.entity.Orders;
import com.shopping.entity.OrderDetail;
import com.shopping.entity.Product;
import com.shopping.entity.Review;
import com.shopping.entity.User;

public class ShoppingApp {

	public static void main(String[] args) {
		
		SessionFactory factory = null;
		try {
			factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			Session session = factory.openSession();
			
			User user = new User("1", "Rai", "rai@123","Hyderabad", 822434534,'A');
			session.save(user);

			Review review = new Review("1",4.5,"Quality is good " ,'A',user);
			session.save(review);

			Category category = new Category("1", "Women Western",'I');
            session.save(category);
			session.beginTransaction();
			
			Product product = new Product("1", "Laptop", "More scalability", 50000.00,"Not in Stock",'A',category);
			session.save(product);

			Orders order = new Orders("1", LocalDate.parse("2023-01-14"), 876.00, "PlotNo:1-7,Nagarjuna colony,HYD,RoadNo:10","NetBanking"," OrderShipped",'A',user);
			session.save(order); 
			
			OrderDetail orderDetail = new OrderDetail(1, product,order,3,'A'); 
			session.save(orderDetail);
			
			
			
			
			session.getTransaction().commit();
			session.clear();
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	

	}


