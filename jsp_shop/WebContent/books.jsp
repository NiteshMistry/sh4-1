<%@page import="com.sunbeam.sh4.jsp_shop.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Books</title>
</head>
<body>
	<jsp:useBean id="lb" class="com.sunbeam.sh4.jsp_shop.LoginBean" scope="session"/>
	Hello, <jsp:getProperty name="lb" property="uname" /> <hr/>

	<jsp:useBean id="bb" class="com.sunbeam.sh4.jsp_shop.BooksBean"/>
	<jsp:setProperty name="bb"  property="subject" param="subject" />
	<% bb.fetchBooks(); %>
	<form method="post" action="addcart.jsp">
	<% for(Book b:bb.getBookList()) { %>
		<input type="checkbox" name="book" value="<%= b.getId() %>"/> <%= b.getName() + " -- " + b.getAuthor() %> <br/> 
	<% } %>
		<input type="submit" value="Add Cart"/>
	</form>
</body>
</html>

