package com.shoping.ImplDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import com.shoping.entity.UserDTO;

public class UserDAO {
	private  Session session;
	
	public UserDAO( final Session session) {
		this.session = session;
	}

	public void saveUser(UserDTO userdto) {
		try
		{
			session.beginTransaction();
			session.save(userdto);
			session.getTransaction().commit();
			
			session.clear();
			
			
		}catch(HibernateException e) {
			System.out.println("Hibernate Exception:" + e);
			
		}catch(Exception e) {
			System.out.println("Exception:" + e);
		}
	}//end
	
	
	
}
