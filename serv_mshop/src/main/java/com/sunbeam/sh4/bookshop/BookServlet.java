package com.sunbeam.sh4.bookshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/books")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subject  = request.getParameter("subject");
		List<Book> list = new ArrayList<Book>();
		try (BookDao dao = new BookDao()) {
			dao.open();
			list = dao.getBooks(subject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>Books</title></head>");
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
		out.println("<h3>Books</h3>");
		out.println("<form method='post' action='addcart'>");
		for (Book b : list) {
			out.printf("<input type='checkbox' name='book' value='%d'/> %s (%s)<br/>\r\n", b.getId(), b.getName(), b.getAuthor());
		}
		out.println("<input type='submit' value='Add Cart'/>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");								
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
