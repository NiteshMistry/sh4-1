package com.sunbeam.sh4.hib2;

public class Hib2Main {
	public static void main(String[] args) {
		
		try (BookDao dao = new BookDao()) {
			dao.open();
			Book b = new Book(1001, "ABC", "PQR", "XYZ", 123);
			dao.addBook(b);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Book b = null;
		try (BookDao dao = new BookDao()) {
			dao.open();
			b = dao.getBook(1001);
			System.out.println("FOUND : " + b);
			Book b2 = dao.getBook(1001);
			System.out.println("FOUND : " + b2);
			System.out.println("Same : " + (b==b2));
			b.setAuthor("LMN");
			dao.updateBook(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// now b is detached -- no more part of session cache.
		
	}
}
