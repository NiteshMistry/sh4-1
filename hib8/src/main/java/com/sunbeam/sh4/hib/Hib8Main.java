package com.sunbeam.sh4.hib;

import org.hibernate.Session;

public class Hib8Main {
	public static void main(String[] args) {
		Session session = HbUtil.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		Student stud = session.get(Student.class, new StudStdRoll(1, 1));
		System.out.println(stud);
		session.getTransaction().commit();
	}
}

