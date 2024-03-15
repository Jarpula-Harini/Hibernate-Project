package com.shopping.service;

import java.util.List;

import com.shopping.entity.User;

public interface UserService {
	
    public boolean createUser(User user);
	
	public User getUserById(String userId);
	
	public boolean updateUser(String userId,User user);
	
	public boolean deleteUser(String userId);
	
	public List<User> getAllUsers();
	
	
	

}
