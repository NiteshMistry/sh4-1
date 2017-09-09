package com.sunbeam.sh4.hib;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Types;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.jdbc.ReturningWork;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

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
	public List<Book> getAuthorBooks(String author) {
		NativeQuery<Book> q = session.getNamedNativeQuery("qry_StoProcGetByAuthor");
		q.setParameter("p_au", author);
		return q.getResultList();
	}
	public double getBookPrice(int id) {
		double price = session.doReturningWork(new ReturningWork<Double>() {
			@Override
			public Double execute(Connection con) throws SQLException {
				try(CallableStatement stmt = con.prepareCall("{CALL SP_BOOKPRICE(?,?)}")) {
					stmt.setInt(1, id);
					stmt.registerOutParameter(2, Types.DOUBLE);
					stmt.execute();
					return stmt.getDouble(2);
				}
			}
		});
		return price;
	}
}
