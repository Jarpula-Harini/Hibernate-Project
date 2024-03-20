package com.shopping.serviceimpl;

import java.util.List;

import com.shopping.dao.OrdersDao;
import com.shopping.daoimpl.OrdersDAOImpl;
import com.shopping.entity.Orders;
import com.shopping.service.OrdersService;

public class OrdersServiceImpl implements OrdersService {
	
	OrdersDao orderDao = new OrdersDAOImpl();

	@Override
	public boolean createOrder(Orders order) {
		return orderDao.createOrder(order);
		
	}

	@Override
	public Orders getOrderById(String orderId) {
		return orderDao.getOrderById(orderId);
		
	}
	
	@Override
	public boolean updateOrder(String orderId, Orders order) {
		return orderDao.updateOrder(orderId, order);
		
	}

	

	@Override
	public boolean deleteOrder(String orderId) {
	return orderDao.deleteOrder(orderId);
		
	}

	@Override
	public List<Orders> getAllOrders() {
		return orderDao.getAllOrders();
	}

	/*
	 * @Override public void getOrderByUserId(String userId) {
	 * orderDao.getOrderByUserId(userId);
	 * 
	 * }
	 */
	

	
	


	

}
