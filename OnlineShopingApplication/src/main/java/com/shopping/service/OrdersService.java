package com.shopping.service;

import java.util.List;

import com.shopping.entity.Orders;

public interface OrdersService {
	
	 public boolean createOrder(Orders order);
	 
	 public Orders getOrderById (String orderId);
	 
	 public boolean updateOrder(String orderId,Orders order);
	 
	 public boolean deleteOrder(String orderId);
	 
	 public  List<Orders> getAllOrders ();
	 
	// public void getOrderByUserId(String userId);


}
