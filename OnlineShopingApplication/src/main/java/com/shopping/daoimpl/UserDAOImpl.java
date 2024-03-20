package com.shopping.daoimpl;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.shopping.dao.UserDao;
import com.shopping.entity.User;
import com.shopping.util.HibernateUtil;

public class UserDAOImpl implements UserDao {

	public boolean createUser(User user) {
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();

			return true;
		} catch (HibernateException e) {
			System.out.println("Hibernate Exception:" + e);

		} catch (Exception e) {
			System.out.println("Exception:" + e);
		}
		return false;
	}// end

	public User getUserById(String userId) {

		try (Session session = HibernateUtil.getSession()) {

			User users = session.get(User.class, userId);

			return users;
		} catch (HibernateException e) {
			System.out.println("HibernateException:" + e);
		} catch (Exception ex) {
			System.out.println("Exception:" + ex);

		}

		return null;
	}

	public boolean updateUser(String userId, User user) {

		try (Session session = HibernateUtil.getSession()) {

			User existUser = session.load(User.class, userId);

			existUser.setUserName(user.getUserName());
			existUser.setPassWord(user.getPassWord());
			existUser.setAddress(user.getAddress());
			existUser.setPhoneNumber(user.getPhoneNumber());
			// existUser.setStatus(user.getStatus());

			session.beginTransaction();
			session.saveOrUpdate(existUser);
			session.getTransaction().commit();
			return true;

		} catch (HibernateException e) {
			System.out.println("HibernateException:" + e);
		} catch (Exception ex) {
			System.out.println("Exception:" + ex);

		}
		return false;
	}

	@Override
	public boolean deleteUser(String userId) {
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			User user = session.get(User.class, userId);

			if (user != null) {
				user.setStatus('I');

				session.saveOrUpdate(user);
				session.getTransaction().commit();
				return true;

			} else {
				System.out.println("User details not found!!");
			}

		} catch (HibernateException e) {
			System.out.println("Hibernate exception is: " + e);
		} catch (Exception e) {
			System.out.println("Exception is: " + e);
		}
		return false;

	}

	@Override
	public List<User> getAllUsers() {
		Session session = HibernateUtil.getSession();

		List<User> userList = session.createQuery("from User", User.class).getResultList();
		return userList;
	}

}
