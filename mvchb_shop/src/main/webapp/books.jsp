<%@page import="com.sunbeam.sh4.shop.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Books</title>
</head>
<body>
	Hello, ${lb.uname} <hr/>

	<jsp:useBean id="bb" class="com.sunbeam.sh4.shop.BooksBean"/>
	<jsp:setProperty name="bb"  property="subject" param="subject" />
	${ bb.fetchBooks() }
	<form method="post" action="controller?page=addcart">
	<c:forEach var="b" items="${bb.bookList}">
		<input type="checkbox" name="book" value="${b.id}"/> ${b.name.concat(" - ").concat(b.author)} <br/>
	</c:forEach>
		<input type="submit" value="Add Cart"/>
	</form>
</body>
</html>

