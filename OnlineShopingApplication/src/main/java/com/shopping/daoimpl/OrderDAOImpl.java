package com.shopping.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.shopping.dao.OrderDao;
import com.shopping.entity.Orders;
import com.shopping.util.HibernateUtil;

public class OrderDAOImpl implements OrderDao {
	
	
	public boolean createOrder(Orders order) {
		
		try  (Session session=HibernateUtil.getSession()){
			
			session.beginTransaction();
			session.save(order);
			session.getTransaction().commit();
			session.clear();
			
			return true;
			
		}catch(HibernateException ex) {
			System.out.println("HibernateException:" + ex);
		}catch(Exception e) {
			System.out.println("Exception:" + e);
		}
		return false;
		
	}
	
	 public Orders getOrderById (String orderId) {
	try (Session session=HibernateUtil.getSession()){

		Orders order = session.get(Orders.class, orderId);

		return order;
	} catch (HibernateException e) {
		System.out.println("HibernateException:" + e);
	} catch (Exception ex) {
		System.out.println("Exception:" + ex);

	}

	return null;
	
	 }//
	 
	 public boolean updateOrder(String orderId ,Orders order) {
		 try (Session session=HibernateUtil.getSession()){

			 Orders existOrder = session.load(Orders.class, orderId);

				existOrder.setOrderDate(order.getOrderDate());
				existOrder.setTotalAmount(order.getTotalAmount());
				existOrder.setShippingAddress(order.getShippingAddress());
				existOrder.setPaymentMethod(order.getPaymentMethod());
				existOrder.setStatus(order.getStatus());
				existOrder.setUser(order.getUser());

				session.beginTransaction();
				session.saveOrUpdate(existOrder);
				session.getTransaction().commit();
				return true;

			} catch (HibernateException e) {
				System.out.println("HibernateException:" + e);
			} catch (Exception ex) {
				System.out.println("Exception:" + ex);

			}
			return false;
	 }//
	 
	 public boolean deleteOrder(String orderId) {
		 try (Session session=HibernateUtil.getSession()){
				
			 Orders order = session.get(Orders.class, orderId);
				session.beginTransaction();
				if (order != null) {
					session.delete(order);
					
					return true;
				} else {
					System.out.println("Order details not found!!");
				}

			} catch (HibernateException e) {
				System.out.println("Hibernate exception is: " + e);
			} catch (Exception e) {
				System.out.println("Exception is: " + e);
			}
		 return false;
		 
	 }//
	 
	 public List<Orders> getAllOrders (){
		 Session session = HibernateUtil.getSession();
			
			List<Orders> orderList = session.createQuery("from Order", Orders.class).getResultList();
			return orderList;
		 
	 }

		/*
		 * @Override public Order getOrderByUserId(String userId) {
		 * 
		 * try (Session session=HibernateUtil.getSession()){
		 * 
		 * Order order = session.get(Order.class, userId);
		 * 
		 * return order; } catch (HibernateException e) {
		 * System.out.println("HibernateException:" + e); } catch (Exception ex) {
		 * System.out.println("Exception:" + ex);
		 * 
		 * }
		 * 
		 * return null;
		 * 
		 * 
		 * }
		 * 
		 * 
		 * 
		 */



	

	
}
