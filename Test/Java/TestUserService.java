package com.shopping.test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.shopping.entity.User;
import com.shopping.service.UserService;
import com.shopping.serviceimpl.UserServiceImpl;
import com.shopping.util.HibernateUtil;

class TestUserService {

	static SessionFactory sessionFactory;
	static Session session;
	static UserService userService;

	@BeforeAll
	static void setUp() {
		sessionFactory = HibernateUtil.getSessionFactory();

		userService = new UserServiceImpl();
	}

	@Test
	void testCreateUser() {

		User user = new User("102", "Virat", "virat@123", "Pune", 958594390, 'A');
		assertTrue(userService.createUser(user));

		User testUser1 = new User("103", "Rohit", "rohit@13", "Mumbai", 87559487, 'A');
		assertTrue(userService.createUser(testUser1));

		User testUser2 = new User("104", "JaneSmith", "jane@09", "HYD", 985594098, 'A');
		assertTrue(userService.createUser(testUser2));

	}

	@Test
	void testGetUserById() {

		User users = userService.getUserById("1");
		assertNotNull(userService.createUser(users));

	}

	@Test
	void testUpdateUser() {
		User users = new User("1", "Jhon", "john@234", "Delhi", 7855648, 'A');

		boolean updatedUsers = userService.updateUser("1", users);
		assertTrue(updatedUsers);

	}

	@Test

	void testGetAllUsers() {

		List<User> userList = userService.getAllUsers();
		assertNotNull(userList);

	}

	@Test
	void testDeleteUser() {
		boolean success = userService.deleteUser("1");
		assertTrue(success);
		// assertNull(userService.getUserById("1"));
	}

	@AfterAll
	static void tearDown() {
		sessionFactory.close();
	}

}
