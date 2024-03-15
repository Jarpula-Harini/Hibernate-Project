package com.shopping.service;

import java.util.List;

import com.shopping.entity.OrderDetail;

public interface OrderDetailService {

	public boolean createOrderDetail(OrderDetail order);

	public OrderDetail getOrderDetailById(int orderDetailId);

	public boolean updateOrderDetail(int orderDetailId, OrderDetail orderDetail );

	public boolean deleteOrderDetail(int orderDetailId);

	public List<OrderDetail> getAllOrderDetail();

}
