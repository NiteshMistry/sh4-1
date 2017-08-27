package hbtest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HbTestMain {
	private static Logger logger= LoggerFactory.getLogger(HbTestMain.class);
	public static void main(String[] args) {
		logger.info("START APPLICATION....");
		SessionFactory sessionFactory = HbUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		//Book b = session.get(Book.class, 11);
		Book b = session.byId(Book.class).load(11);
		System.out.println(b);
		session.close();
		sessionFactory.close();
	}
}
