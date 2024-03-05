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

