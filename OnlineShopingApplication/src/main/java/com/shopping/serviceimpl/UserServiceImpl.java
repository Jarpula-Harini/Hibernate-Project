package com.shopping.serviceimpl;

import java.util.List;

import com.shopping.dao.UserDao;
import com.shopping.daoimpl.UserDAOImpl;
import com.shopping.entity.User;
import com.shopping.service.UserService;

public class UserServiceImpl implements UserService{
	
	UserDao userDao = new UserDAOImpl();
	
	
	  public boolean createUser(User user) {
		  return userDao.createUser(user);
		
	  }
	  
	  public User getUserById(String userId) {
		  return userDao.getUserById(userId);
	  }
	
	  public boolean updateUser(String userId,User user) {
		  
		  return userDao.updateUser(userId, user);
	  }
	  
	  public boolean deleteUser(String userId) {
		  return userDao.deleteUser(userId);
	  }
	  
	  public List<User> getAllUsers(){
		  return userDao.getAllUsers();
	  }

	
	

}
