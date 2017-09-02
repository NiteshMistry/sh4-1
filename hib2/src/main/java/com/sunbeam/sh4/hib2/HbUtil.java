package com.sunbeam.sh4.hib2;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HbUtil {
	private static SessionFactory factory = buildSessionFactory();
	private static SessionFactory buildSessionFactory() {
		Configuration cfg = new Configuration(); // empty config object
		cfg.configure(); // read hibernate.cfg.xml file
		return cfg.buildSessionFactory(); // create session factory using settings in cfg
	}
	public static SessionFactory getSessionFactory() {
		return factory;
	}
	public static void shutdown() {
		factory.close();
	}
}
