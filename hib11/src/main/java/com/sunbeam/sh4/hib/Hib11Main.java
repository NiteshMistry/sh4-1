package com.sunbeam.sh4.hib;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class Hib11Main {
	public static void main(String[] args) {
		SessionFactory factory = HbUtil.getSessionFactory();
		
		Session session = factory.openSession();
		session.getTransaction().begin();
		Book b1 = session.get(Book.class, 11);
		System.out.println(b1);
		session.getTransaction().commit();
		session.close();
		
		session = factory.openSession();
		session.getTransaction().begin();
		Book b2 = session.get(Book.class, 11);
		System.out.println(b2);
		session.getTransaction().commit();
		System.out.println(b1==b2);
		session.close();

		session = factory.openSession();
		session.getTransaction().begin();
		Query<Book> q = session.createQuery("from Book b");
		q.setCacheable(true);
		List<Book> list = q.getResultList();
		for (Book b : list) {
			System.out.println(b);
		}
		session.getTransaction().commit();
		session.close();
		
		session = factory.openSession();
		session.getTransaction().begin();
		q = session.createQuery("from Book b");
		q.setCacheable(true);
		list = q.getResultList();
		for (Book b : list) {
			System.out.println(b);
		}
		session.getTransaction().commit();
		session.close();
		
		HbUtil.shutdown();
	}
}
