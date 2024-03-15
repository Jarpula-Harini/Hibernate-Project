package com.shopping.dao;

import java.util.List;

import com.shopping.entity.Orders;



public interface OrderDao {
	
	 public boolean createOrder(Orders order);
	 
	 public Orders getOrderById (String orderId);
	 
	 public boolean updateOrder(String orderId, Orders order );
	 
	 public boolean deleteOrder(String orderId);
	 
	 public List<Orders> getAllOrders ();
	 
	// public Order getOrderByUserId(String userId);
	

}
