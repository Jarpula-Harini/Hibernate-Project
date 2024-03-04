package com.shoping.Main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.shoping.ImplDao.UserDAO;
import com.shoping.entity.UserDTO;


public class SystemApp {

	public static void main(String[] args) {
		SessionFactory factory = null;
		
		
		try {
		   factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

			Session session = factory.openSession();
			
			UserDAO userDao = new UserDAO(session);
			
			
			UserDTO user1 = new UserDTO("Rahul","rahul@123","HYD",84938);
			UserDTO user2 = new UserDTO("Virat","virat@123","MBNGR",90965);
			UserDTO user3 = new UserDTO("Rohit","rohit@123","Pune",64490);
				
			    userDao.saveUser(user1);
				userDao.saveUser(user2);
				userDao.saveUser(user3);
				
				
				
				
				
				
			
			
			
			


	
	}catch(HibernateException e) {
		
		e.printStackTrace();
		System.out.println("Exception");
	} finally {
		if (factory != null) {
			factory.close();
		}
	}
	}
	}

