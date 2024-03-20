package com.shopping.test;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.shopping.entity.Category;
import com.shopping.entity.OrderDetail;
import com.shopping.entity.Orders;
import com.shopping.entity.Product;
import com.shopping.entity.User;
import com.shopping.service.OrderDetailService;
import com.shopping.serviceimpl.OrderDetailServiceImpl;
import com.shopping.util.HibernateUtil;

class TestOrderDetailService {

	
	
	static SessionFactory sessionFactory;
	static Session session;
	static OrderDetailService orderDetailService;

	@BeforeAll
	static void setUp() {
		sessionFactory = HibernateUtil.getSessionFactory();

		orderDetailService = new OrderDetailServiceImpl();
	}

	@Test
	void testcreateOrderDetail() {

		Category category = new Category("4","Electronics",'A');
		Product product = new Product("1", "Smart Watch", "Digital Watch Combo BUY 1 GET 1 FREE",899.00, "InStock", 'A',category);
		User user = new User("102", "Virat", "virat@123", "Pune", 958594390, 'A');
		Orders order = new Orders("3", LocalDate.parse("2024-03-15"),400.00, "7A-9,JitColony,Hyderabad", "NetBanking","OrderShipped", 'A',user);
		OrderDetail orderDetail = new OrderDetail(2, product, order, 2, 'A');
		assertTrue(orderDetailService.createOrderDetail(orderDetail));
	}

	
	@Test
	void testGetOrderDetailById() {

		OrderDetail orderDetail = orderDetailService.getOrderDetailById(1);
		assertNotNull(orderDetailService.createOrderDetail(orderDetail));

	}

		@Test
	void testUpdateUser() {
		

		Category category = new Category("4","Electronics",'A');
		Product product = new Product("1", "Smart Watch", "Digital Watch Combo BUY 1 GET 1 FREE",899.00, "InStock", 'A',category);
		User user = new User("102", "Virat", "virat@123", "Pune", 958594390, 'A');
		Orders order = new Orders("3", LocalDate.parse("2024-03-15"),400.00, "7A-9,JitColony,Hyderabad", "NetBanking","OrderShipped", 'A',user);
	    OrderDetail orderDetail = new OrderDetail(2, product, order, 2, 'A');
		boolean updatedOrderDetail = orderDetailService.updateOrderDetail(1, orderDetail);
		assertTrue(updatedOrderDetail);

	} 

	@Test

		void testGetAllOrderDetai() {

		List<OrderDetail> orderDetailList = orderDetailService.getAllOrderDetail();
		assertNotNull(orderDetailList);

	} 

	@Test
	void testDeleteOrderDetail() {
		boolean success = orderDetailService.deleteOrderDetail(1);
		assertTrue(success);
		
	} 

	@AfterAll
	static void tearDown() {
		sessionFactory.close();
	}


}
