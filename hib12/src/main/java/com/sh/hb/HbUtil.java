package com.sh.hb;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HbUtil {
	private static final SessionFactory factory = buildSessionFactory();
	private static SessionFactory buildSessionFactory() {
		// create config object
		Configuration cfg = new Configuration();
		// read config from hibernate.cfg.xml
		cfg.configure(); 
		// create session factory from that config
		return cfg.buildSessionFactory();
	}
	public static SessionFactory getSessionFactory() {
		return factory;
	}
}
