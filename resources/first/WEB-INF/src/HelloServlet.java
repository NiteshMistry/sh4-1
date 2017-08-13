package com.sunbeam.sh4;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;


public class HelloServlet extends HttpServlet {
	public HelloServlet() {
		System.out.println("HelloServlet object created.");
	}
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("HelloServlet.init() called.");
	}
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		System.out.println("HelloServlet.doGet() called.");
		processRequest(req, resp);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		System.out.println("HelloServlet.doPost() called.");
		processRequest(req, resp);
	}
	public void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><title>Hello Servlet</title></head>");
		out.println("<body>");
		out.println("<h1>Welcome Spring-Hibernate Course!</h1>");
		out.println("<h3>Wake up from Hibernate & Spring Up!</h3>");
		out.println("<h4>HTTP GET/POST Method</h4>");
		out.println("</body>");
		out.println("</html>");
	}
	public void destroy() {
		System.out.println("HelloServlet.destroy() called.");
	}
}


