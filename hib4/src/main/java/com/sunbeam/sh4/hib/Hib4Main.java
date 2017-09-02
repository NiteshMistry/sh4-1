package com.sunbeam.sh4.hib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Hib4Main {
	public static void main(String[] args) {
		SessionFactory factory = HbUtil.getSessionFactory();
		Session session = factory.openSession();
		Dept d = session.get(Dept.class, 10);
		System.out.println(d);
		for (Emp e : d.getEmpList()) {
			System.out.println(e);
		}
		session.close();
		factory.close();
	}
}

