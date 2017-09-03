package com.sunbeam.sh4.hib3;

import java.util.Iterator;
import java.util.List;

public class Hib3Main {
	public static void main(String[] args) {
		//		try (BookDao dao = new BookDao()) {
		//			dao.open();
		//			List<Book> list = dao.getBooksOfSubject("C");
		//			for (Book b : list) {
		//				System.out.println(b);
		//			}
		//		} catch (Exception e) {
		//			e.printStackTrace();
		//		}

		//		try (BookDao dao = new BookDao()) {
		//			dao.open();
		//			List<Book> list = dao.getBooksOfSubjectAndAuthor("C", "KANETKAR");
		//			for (Book b : list) {
		//				System.out.println(b);
		//			}
		//		} catch (Exception e) {
		//			e.printStackTrace();
		//		}

		//		try (BookDao dao = new BookDao()) {
		//			dao.open();
		//			List<Book> list = dao.getBooksOfSubjectOrAuthor("C", "Schildt");
		//			for (Book b : list) {
		//				System.out.println(b);
		//			}
		//		} catch (Exception e) {
		//			e.printStackTrace();
		//		}

		//		try (BookDao dao = new BookDao()) {
		//			dao.open();
		//			List<String> list = dao.getSubjects();
		//			System.out.println(list);
		//		} catch (Exception e) {
		//			e.printStackTrace();
		//		}

		try (BookDao dao = new BookDao()) {
			dao.open();
			List<Book> list = dao.hqlGetBooksOfSubject("C");
			for (Book b : list) {
				System.out.println(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

//		try (BookDao dao = new BookDao()) {
//			dao.open();
//			List<Object[]> list = dao.hqlSelectColumns();
//			for (Object[]arr : list) {
//				System.out.println(arr[0] + ", " + arr[1] + ", " + arr[2]);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	
//		try (BookDao dao = new BookDao()) {
//			dao.open();
//			List<Book> list = dao.hqlSelectColumnsTransformResult();
//			for (Book b : list) {
//				System.out.println(b);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		try (BookDao dao = new BookDao()) {
			dao.open();
			List<Book> list = dao.hqlSelectColumnsInObject();
			for (Book b : list) {
				System.out.println(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
