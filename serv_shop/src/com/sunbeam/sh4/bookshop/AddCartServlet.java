package com.sunbeam.sh4.bookshop;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/addcart")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] bookIds = request.getParameterValues("book");
		//convert ids into int and store them
		HttpSession session = request.getSession();
		List<Integer> cart = (List<Integer>) session.getAttribute("cart");
		for (String bkId : bookIds) {
			int id = Integer.parseInt(bkId);
			cart.add(id);
		}
		RequestDispatcher rd = request.getRequestDispatcher("subjects");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
