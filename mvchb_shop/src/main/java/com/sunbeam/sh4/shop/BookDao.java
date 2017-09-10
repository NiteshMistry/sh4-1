package com.sunbeam.sh4.shop;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.transform.ResultTransformer;

public class BookDao implements AutoCloseable {
	private Session session;
	public void open() {
		session = HbUtil.getSessionFactory().openSession();
	}
	public void close() {
		if(session!=null)
			session.close();
	}
	public Book getBook(int id) {
		Book b = session.get(Book.class, id);
		return b;
	}
	public void addBook(Book b) {
		Transaction tx = session.beginTransaction();
		try {
			session.persist(b);
			//session.flush();
			tx.commit();
		}catch (Exception e) {
			tx.rollback();
		}
	}
	public List<Book> getBooks(String subject) {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Book> query = builder.createQuery(Book.class);
		Root<Book> root = query.from(Book.class);
		query.select(root);
		query.where(builder.equal(root.get("subject"), subject));
		Query<Book> q = session.createQuery(query);
		return q.getResultList();
	}	
	public List<String> getSubjects() {
		String sql = "SELECT DISTINCT SUBJECT FROM BOOKS";
		NativeQuery q = session.createSQLQuery(sql);
		return q.list();
	}
	
}




