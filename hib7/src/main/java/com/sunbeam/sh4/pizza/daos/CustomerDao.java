package com.sunbeam.sh4.pizza.daos;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.sunbeam.sh4.pizza.entities.Customer;
import com.sunbeam.sh4.pizza.utils.HbUtil;

public class CustomerDao {
	public Customer getCustomer(String email) {
		Session session = HbUtil.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Customer> query = builder.createQuery(Customer.class);
		Root<Customer> root = query.from(Customer.class);
		query.where(builder.equal(root.get("email"), email));
		query.select(root);
		Query<Customer> q = session.createQuery(query);
		Customer cust = q.getSingleResult();
		session.getTransaction().commit();
		return cust;
	}
}
