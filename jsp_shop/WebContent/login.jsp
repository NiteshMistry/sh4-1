<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Check</title>
</head>
<body>
	<jsp:useBean id="lb" class="com.sunbeam.sh4.jsp_shop.LoginBean" scope="session"/>
	<jsp:setProperty name="lb"  property="*" />
	<% if(lb.getStatus() == true) { %>
		<jsp:forward page="subjects.jsp"/>
	<% } else { %>
		Sorry, <jsp:getProperty name="lb" property="uname" />
		<br/>
		Invalid username or password.
		<br/>
		<a href="index.jsp">Login Again</a>
	<% } %>
</body>
</html>
