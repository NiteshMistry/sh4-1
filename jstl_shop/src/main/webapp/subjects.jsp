<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Subjects</title>
</head>
<body>
	Hello, ${lb.uname} <hr/>
	
	<jsp:useBean id="sb" class="com.sunbeam.sh4.jsp_shop.SubjectBean"/>
	${ sb.fetchSubjects() }
	<form method="post" action="books.jsp">
	<c:forEach var="subject" items="${sb.subjectList}">
		<input type="radio" name="subject" value="${subject}"/> ${subject} <br/>
	</c:forEach>
	<input type="submit" value="Show Books"/>
	<a href="showcart.jsp">Show Cart</a>
	</form>
</body>
</html>
