package com.shopping.test;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.shopping.entity.Orders;
import com.shopping.entity.User;
import com.shopping.service.OrdersService;
import com.shopping.serviceimpl.OrdersServiceImpl;
import com.shopping.util.HibernateUtil;

class TestOrdersService {

	static SessionFactory sessionFactory;
	static Session session;
	static OrdersService ordersService;

	@BeforeAll
	static void setUp() {
		sessionFactory = HibernateUtil.getSessionFactory();

		ordersService = new OrdersServiceImpl();
	}

	@Test
	void testCreateOrders() {

		User user = new User("103", "Virat", "virat@123", "Pune", 958594390, 'A');
		Orders order = new Orders("3", LocalDate.parse("2024-03-15"), 400.00, "7A-9,JitColony,Hyderabad", "NetBanking",
				"OrderShipped", 'A', user);
		assertTrue(ordersService.createOrder(order));
	}

	@Test
	void testGetOrderById() {

		Orders order = ordersService.getOrderById("1");
		assertNotNull(ordersService.createOrder(order));

	}

	@Test
	void testUpdateOrder() {
		User user = new User("1", "Jhon", "john@234", "Delhi", 7855648, 'A');

		Orders order = new Orders("3", LocalDate.parse("2024-03-15"), 400.00, "7A-9,JitColony,Hyderabad", "NetBanking",
				"OrderShipped", 'A', user);
		boolean updatedOrder = ordersService.updateOrder("1", order);
		assertTrue(updatedOrder);

	}

	@Test
	void testGetAllOrders() {

		List<Orders> ordersList = ordersService.getAllOrders();
		assertNotNull(ordersList);

	}

	@Test
	void testDeleteOrder() {
		boolean success = ordersService.deleteOrder("1");
		assertTrue(success);

	}
	
	@AfterAll
	static void tearDown() {
		sessionFactory.close();
	}

}
