package com.sunbeam.sh4.bookshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/showcart")
public class ShowCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>Cart</title></head>");
		out.println("<body>");
		String uname = "";
		Cookie[] arr = request.getCookies();
		if(arr!=null) {
			for (Cookie c : arr) {
				if(c.getName().equals("user"))
					uname = c.getValue();
			}
			out.println("Hello, " + uname + "<hr/>");
		}
		out.println("<h3>Cart</h3>");
		//Show all book details from cart of current user.
		HttpSession session = request.getSession();
		List<Integer> cart = (List<Integer>) session.getAttribute("cart");
		for (int id : cart) {
			out.println("<div>");
			out.println("Book Id : " + id);
			out.println("</div>");
		}
		out.println("<a href='logout'>Sign Out</a>");
		out.println("</body>");
		out.println("</html>");								
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
