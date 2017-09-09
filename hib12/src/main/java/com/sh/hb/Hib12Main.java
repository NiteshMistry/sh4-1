package com.sh.hb;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class Hib12Main {
	public static void main(String[] args) {
		SessionFactory factory = HbUtil.getSessionFactory();
		Session session = factory.openSession();
		Query<VegItem> q = session.createQuery("from VegItem vi");
		List<VegItem> list = q.getResultList();
		for (VegItem vegItem : list) {
			System.out.println(vegItem);
		}
		session.close();
		factory.close();
	}
}
