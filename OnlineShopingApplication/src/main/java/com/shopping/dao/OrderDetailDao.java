package com.shopping.dao;

import java.util.List;

import com.shopping.entity.OrderDetail;

public interface OrderDetailDao {

	public boolean createOrderDetail(OrderDetail order);
	
	public OrderDetail getOrderDetailById(int orderDetailId);

	public boolean updateOrderDetail(int orderDetailId, OrderDetail updatedOrderDetail);

	public boolean deleteOrderDetail(int orderDetailId);

	public List<OrderDetail> getAllOrderDetail();

}
