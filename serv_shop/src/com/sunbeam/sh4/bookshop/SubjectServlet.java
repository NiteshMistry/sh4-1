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

@WebServlet("/subjects")
public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> list = new ArrayList<>();
		try(BookDao dao = new BookDao()) {
			dao.open();
			list = dao.getSubjects();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>Subjects</title></head>");
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
		out.println("<h3>Subjects</h3>");
		out.println("<form method='get' action='books'>");
		for (String subject : list) {
			out.printf("<input type='radio' name='subject' value='%s'/> %s<br/>\r\n", subject, subject);
		}
		out.println("<input type='submit' value='Show Books'/>");
		out.println("<a href='showcart'>Show Cart</a>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");						
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
