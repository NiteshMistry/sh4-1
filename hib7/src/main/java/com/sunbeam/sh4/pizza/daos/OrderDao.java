package com.sunbeam.sh4.pizza.daos;

import org.hibernate.Session;

import com.sunbeam.sh4.pizza.entities.Order;
import com.sunbeam.sh4.pizza.utils.HbUtil;

public class OrderDao {
	public void addOrder(Order order) {
		Session session = HbUtil.getSessionFactory().getCurrentSession();
		session.persist(order);
	}
	public Order getOrder(int id) {
		Session session = HbUtil.getSessionFactory().getCurrentSession();
		return session.get(Order.class, id);
	}
}
