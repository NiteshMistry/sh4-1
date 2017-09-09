package com.sunbeam.sh4.hib;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.BootstrapServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HbUtil {
	private static SessionFactory factory = buildSessionFactory();
	private static SessionFactory buildSessionFactory() {
		try {
			StandardServiceRegistry standardRegistry = 
					new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			Metadata metaData = 
					new MetadataSources(standardRegistry).getMetadataBuilder().build();
			SessionFactory sessionFactory = metaData.getSessionFactoryBuilder().build();
			return sessionFactory;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	public static SessionFactory getSessionFactory() {
		return factory;
	}
	public static void shutdown() {
		factory.close();
	}
}
