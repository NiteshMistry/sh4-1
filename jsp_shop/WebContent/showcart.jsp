<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="bookshop" uri="/booshop-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cart</title>
</head>
<body>
	<jsp:useBean id="lb" class="com.sunbeam.sh4.jsp_shop.LoginBean" scope="session"/>
	Hello, <jsp:getProperty name="lb" property="uname" /> <hr/>

	<jsp:useBean id="cb" class="com.sunbeam.sh4.jsp_shop.CartBean" scope="session"/>
	<% for(int id : cb.getCart()) { %>
		<%-- <%= id %> <br/> --%>
		<bookshop:showbook id="<%= id %>"/>
	<% } %>
	<a href="logout.jsp">Sign Out</a>
</body>
</html>


