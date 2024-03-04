package com.crud.operation;
import java.util.List;
import com.shoping.entity.UserDTO;

public interface UserDao {
	
	public void saveUser(UserDTO user);
	
	UserDTO getUserById(int userId);
	
	List<UserDTO> getAllUsers();
	
	void updateUser(UserDTO user);
	
	public void deleteUser(int userId);
	

}
