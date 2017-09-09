package com.sunbeam.sh4.hib;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Hib10Main {
	public static void main(String[] args) {
		try (BookDao dao = new BookDao()) {
			dao.open();
			List<Book> list = dao.getAuthorBooks("KANETKAR");
			for (Book b : list) {
				System.out.println(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (BookDao dao = new BookDao()) {
			dao.open();
			double cost = dao.getBookPrice(12);
			System.out.println("Book Cost : " + cost);
		} catch (Exception e) {
			e.printStackTrace();
		}
		HbUtil.shutdown();
	}
}

