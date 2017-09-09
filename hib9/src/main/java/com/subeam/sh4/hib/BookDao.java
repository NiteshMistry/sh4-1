package com.subeam.sh4.hib;

import org.hibernate.Session;
import org.hibernate.Transaction;

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
	public void updateBook(Book b) {
		Transaction tx = session.beginTransaction();
		try {
			session.update(b);
			//session.flush();
			tx.commit();
		}catch (Exception e) {
			tx.rollback();
		}
	}
	public void deleteBook(int id) {
		Transaction tx = session.beginTransaction();
		try {
			Book b = session.get(Book.class, id);
			if(b!=null)
				session.delete(b);
			//session.flush();
			tx.commit();
		}catch (Exception e) {
			tx.rollback();
		}
	}
}
