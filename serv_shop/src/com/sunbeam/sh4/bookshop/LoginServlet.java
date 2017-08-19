package com.sunbeam.sh4.bookshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String upass = request.getParameter("upass");
		try (LoginDao dao = new LoginDao()) {
			dao.open();
			boolean success = dao.checkLogin(uname, upass);
			if(success) {
				Cookie c = new Cookie("user", uname);
				c.setMaxAge(3600);
				response.addCookie(c);
				
				HttpSession session = request.getSession();
				session.setAttribute("cart", new ArrayList<Integer>());
				
				response.sendRedirect("subjects");
			} else {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<html>");
				out.println("<head><title>Login Failed</title></head>");
				out.println("<body>");
				out.println("<h3>Invalid Login.</h3>");
				out.println("<a href='index.html'>Login again</a>");
				out.println("</body>");
				out.println("</html>");				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
