package com.shopping.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.shopping.dao.OrderDetailDao;
import com.shopping.entity.OrderDetail;
import com.shopping.util.HibernateUtil;

public class OrderDetailDAOImpl implements OrderDetailDao {

	public boolean createOrderDetail(OrderDetail order) {
		

		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			session.save(order);
			session.getTransaction().commit();
			

			return true;
		} catch (HibernateException ex) {

			System.out.println("HibernateException:" + ex);
		} catch (Exception e) {
			System.out.println("Exception:" + e);
		}
		return false;
	}

	public OrderDetail getOrderDetailById(int orderDetailId) {
		try (Session session = HibernateUtil.getSession()) {

			OrderDetail orderDetail = session.get(OrderDetail.class, orderDetailId);

			return orderDetail;
		} catch (HibernateException e) {
			System.out.println("HibernateException:" + e);
		} catch (Exception ex) {
			System.out.println("Exception:" + ex);

		}

		return null;
	}

	public boolean updateOrderDetail(int orderDetailId, OrderDetail updatedOrderDetail) {
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();

			OrderDetail existOrderDetail = session.load(OrderDetail.class, orderDetailId);

			existOrderDetail.setProduct(updatedOrderDetail.getProduct());
			existOrderDetail.setQuantity(updatedOrderDetail.getQuantity());
			existOrderDetail.setOrder(updatedOrderDetail.getOrder());

			session.saveOrUpdate(existOrderDetail);
			session.getTransaction().commit();
			return true;

		} catch (HibernateException e) {
			System.out.println("HibernateException:" + e);
		} catch (Exception ex) {
			System.out.println("Exception:" + ex);

		}
		return false;
	}

	public boolean deleteOrderDetail(int orderDetailId) {
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();

			OrderDetail orderDetail = session.get(OrderDetail.class, orderDetailId);
			
			if (orderDetail != null) {
				orderDetail.setStatus('A');
				session.saveOrUpdate(orderDetail);

				return true;

			} else {
				System.out.println("orderDetail details not found!!");
			}

		} catch (HibernateException e) {
			System.out.println("Hibernate exception is: " + e);
		} catch (Exception e) {
			System.out.println("Exception is: " + e);
		}

		return false;
	}

	public List<OrderDetail> getAllOrderDetail() {

		Session session = HibernateUtil.getSession();

		List<OrderDetail> orderDetailList = session.createQuery("from OrderDetail", OrderDetail.class).getResultList();
		return orderDetailList;

	}

}
