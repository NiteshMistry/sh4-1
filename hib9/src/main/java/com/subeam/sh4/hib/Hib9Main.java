package com.subeam.sh4.hib;

public class Hib9Main {
	public static void main(String[] args) {
		try(BookDao dao = new BookDao()){
			dao.open();
			Book b = new Book(0, "ABC", "PQR", "XYZ", 123);
			dao.addBook(b);
		}catch (Exception e) {
			e.printStackTrace();
		}
		HbUtil.shutdown();
	}
}
