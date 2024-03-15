package com.shopping.serviceimpl;

import java.util.List;

import com.shopping.dao.OrderDetailDao;
import com.shopping.daoimpl.OrderDetailDAOImpl;
import com.shopping.entity.OrderDetail;
import com.shopping.service.OrderDetailService;

public class OrderDetailServiceImpl implements OrderDetailService {
	
	OrderDetailDao orderDetailDao = new OrderDetailDAOImpl();

	@Override
	public boolean createOrderDetail(OrderDetail order) {
		return orderDetailDao.createOrderDetail(order);
		
	}

	@Override
	public OrderDetail getOrderDetailById(int orderDetailId) {
		return orderDetailDao.getOrderDetailById(orderDetailId);
	}

	@Override
	public boolean updateOrderDetail(int orderDetailId, OrderDetail updatedOrderDetail) {
		return orderDetailDao.updateOrderDetail(orderDetailId, updatedOrderDetail);
	}

	@Override
	public boolean deleteOrderDetail(int orderDetailId) {
		return orderDetailDao.deleteOrderDetail(orderDetailId);
	}

	@Override
	public List<OrderDetail> getAllOrderDetail() {
		return orderDetailDao.getAllOrderDetail();
	}
	

}
