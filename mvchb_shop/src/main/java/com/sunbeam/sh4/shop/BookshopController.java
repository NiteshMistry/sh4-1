package com.sunbeam.sh4.shop;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BookshopController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		RequestDispatcher rd = null;
		if(page.equals("index"))
			rd = request.getRequestDispatcher("index.jsp");
		else if(page.equals("login"))
			rd = request.getRequestDispatcher("login.jsp");
		else if(page.equals("subjects"))
			rd = request.getRequestDispatcher("subjects.jsp");
		else if(page.equals("books"))
			rd = request.getRequestDispatcher("books.jsp");
		else if(page.equals("addcart"))
			rd = request.getRequestDispatcher("addcart.jsp");
		else if(page.equals("showcart"))
			rd = request.getRequestDispatcher("showcart.jsp");
		else if(page.equals("logout"))
			rd = request.getRequestDispatcher("logout.jsp");
		else 
			rd = request.getRequestDispatcher("notfound.jsp");
		if(rd!=null)
			rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
