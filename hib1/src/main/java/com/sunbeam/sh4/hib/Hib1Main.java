package com.sunbeam.sh4.hib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Hib1Main {
	public static void main(String[] args) {
	/*
		SessionFactory factory = HbUtil.getSessionFactory();
		Session session = factory.openSession();
		Book b = session.get(Book.class, 101);
		System.out.println("Book Found : " + b);
		session.close();
 	*/
		/*
		try (BookDao dao = new BookDao()) {
			dao.open();
			Book b = new Book(101, "The Alchemist", "Paulo Coelo", "Novell", 300);
			dao.addBook(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		/*
		try (BookDao dao = new BookDao()) {
			dao.open();
			Book b = dao.getBook(101);
			if(b!=null) {
				b.setPrice(500);
				dao.updateBook(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		try (BookDao dao = new BookDao()) {
			dao.open();
			dao.deleteBook(101);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try (BookDao dao = new BookDao()) {
			dao.open();
			Book b = dao.getBook(101);
			System.out.println("Book Found : " + b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		HbUtil.shutdown();
	}
}

