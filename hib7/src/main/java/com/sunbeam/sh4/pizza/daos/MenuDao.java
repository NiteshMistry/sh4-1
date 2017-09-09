package com.sunbeam.sh4.pizza.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.sunbeam.sh4.pizza.entities.Item;
import com.sunbeam.sh4.pizza.entities.ItemPrice;
import com.sunbeam.sh4.pizza.utils.HbUtil;

public class MenuDao {
	public List<String> getTypes() {
		String hql = "select distinct i.type from Item i";
		Session session = HbUtil.getSessionFactory().getCurrentSession();
		Query<String> query = session.createQuery(hql);
		List<String> list = query.getResultList();
		return list;
	}
	public List<String> getCategories(String type) {
		String hql = "select distinct i.category from Item i where i.type=:p_type";
		Session session = HbUtil.getSessionFactory().getCurrentSession();
		Query<String> query = session.createQuery(hql);
		query.setParameter("p_type", type);
		List<String> list = query.getResultList();
		return list;
	}
	public List<Item> getItems(String type, String category) {
		String hql = "select i from Item i where i.type=:p_type and i.category=:p_category";
		Session session = HbUtil.getSessionFactory().getCurrentSession();
		Query<Item> query = session.createQuery(hql);
		query.setParameter("p_type", type);
		query.setParameter("p_category", category);
		List<Item> list = query.getResultList();
		return list;		
	}
	public Item getItem(int id) {
		Session session = HbUtil.getSessionFactory().getCurrentSession();
		return session.get(Item.class, id);
	}
	public ItemPrice getItemPrice(int id) {
		Session session = HbUtil.getSessionFactory().getCurrentSession();
		return session.get(ItemPrice.class, id);
	}
}





