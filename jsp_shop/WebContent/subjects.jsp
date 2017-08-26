<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Subjects</title>
</head>
<body>
	<jsp:useBean id="lb" class="com.sunbeam.sh4.jsp_shop.LoginBean" scope="session"/>
	Hello, <jsp:getProperty name="lb" property="uname" /> <hr/>
	
	<jsp:useBean id="sb" class="com.sunbeam.sh4.jsp_shop.SubjectBean"/>
	<% sb.fetchSubjects(); %>
	<form method="post" action="books.jsp">
	<% for(String subject : sb.getSubjectList()) { %>
		<input type="radio" name="subject" value="<%= subject %>"/> <%= subject %> <br/>
	<% } %>
	<input type="submit" value="Show Books"/>
	<a href="showcart.jsp">Show Cart</a>
	</form>
</body>
</html>
