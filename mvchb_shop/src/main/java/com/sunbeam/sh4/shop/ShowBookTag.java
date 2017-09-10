package com.sunbeam.sh4.shop;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ShowBookTag extends SimpleTagSupport {
	private int id;
	public ShowBookTag() {
		System.out.println("ShowBookTag object created.");
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public void doTag() throws JspException, IOException {
		Book b = null;
		// business logic
		try(BookDao dao = new BookDao()) {
			dao.open();
			b = dao.getBook(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// presentation logic
		if(b!=null) {
			PageContext  pageContext = (PageContext) this.getJspContext();
			JspWriter out = pageContext.getOut();
			out.println("<div>");
			out.println("Id : " + b.getId() + "<br/>");
			out.println("Name : " + b.getName() + "<br/>");
			out.println("Author : " + b.getAuthor() + "<br/>");
			out.println("Subject : " + b.getSubject() + "<br/>");
			out.println("Price : " + b.getPrice() + "<br/>");
			out.println("</div> <br/><br/>");
			
			double total = Double.parseDouble(pageContext.getAttribute("total").toString());
			total = total + b.getPrice();
			pageContext.setAttribute("total", ""+total);
		}
	}	
}
