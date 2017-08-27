package com.sunbeam.sh4.jsp_shop;

import java.util.ArrayList;
import java.util.List;

public class BooksBean {
	private String subject;
	private List<Book> bookList;
	public BooksBean() {
		this.subject = "";
		this.bookList = new ArrayList<>();
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public List<Book> getBookList() {
		return bookList;
	}
	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
	public void fetchBooks() {
		try (BookDao dao = new BookDao()) {
			dao.open();
			bookList = dao.getBooks(subject);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
