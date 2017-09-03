package com.sunbeam.sh4.hib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Hib5Main {
	public static void main(String[] args) {
		SessionFactory factory = HbUtil.getSessionFactory();
		Session session = factory.openSession();
		
//		Emp e = session.get(Emp.class, 7839);
//		System.out.println(e);
//		System.out.println(e.getDept());
		
//		Dept d = session.get(Dept.class, 10);
//		System.out.println(d);
//		for (Emp e : d.getEmpList()) {
//			System.out.println(e);
//		}

//		Dept d = new Dept(50, "TRAINING", "PUNE");
//		Emp e1 = new Emp(100, "NILESH", 20000);
//		Emp e2 = new Emp(101, "SANDEEP", 25000);
//		e1.setDept(d);
//		e2.setDept(d);
//		d.getEmpList().add(e1);
//		d.getEmpList().add(e2);
//		Transaction tx = session.beginTransaction();
//		session.persist(d);
//		tx.commit();

		Dept d = session.get(Dept.class, 50);
		Transaction tx = session.beginTransaction();
		session.delete(d);
		tx.commit();
		
		session.close();
		factory.close();
	}
}

