package com.sunbeam.sh4.pizza.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HbUtil {
	private final static SessionFactory factory = buildSesssionFactory();
	private static SessionFactory buildSesssionFactory() {
		Configuration cfg = new Configuration(); // create empty cfg object.
		cfg.configure(); //load hibernate.cfg.xml contents into cfg object.
		return cfg.buildSessionFactory(); // create SessionFactory from cfg object.
	}
	public static SessionFactory getSessionFactory() {
		return factory;
	}
	public static void newTransaction() {
		factory.getCurrentSession().getTransaction().begin();
	}
	public static void commitTransaction() {
		factory.getCurrentSession().getTransaction().commit();
	}
	public static void rollbackTransaction() {
		factory.getCurrentSession().getTransaction().rollback();
	}
}
