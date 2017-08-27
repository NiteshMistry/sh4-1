<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="bookshop" uri="/booshop-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cart</title>
</head>
<body>
	Hello, ${lb.uname} <hr/>
	<jsp:useBean id="cb" class="com.sunbeam.sh4.jsp_shop.CartBean" scope="session"/>
	<c:set var="count" value="0"/>
	<c:set var="total" value="0.0"/>
	<c:forEach var="id" items="${cb.cart}">
		<bookshop:showbook id="${id}"/>
		<c:set var="count" value="${count + 1}"/>
	</c:forEach>
	<h3>Book Count: ${count}</h3>
	<h3>Total: Rs. ${total}/-</h3>
	<a href="controller?page=logout">Sign Out</a>
</body>
</html>



