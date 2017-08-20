<%@page import="java.util.Random"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="/WEB-INF/pages/error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error Prone</title>
</head>
<body>
	<%! Random r = new Random(); %>
	<%
		Date d = null;
		if(r.nextInt() % 4 == 0)
			d = new Date();
	%>
	<%= d.toString() %>
</body>
</html>
