<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	Page 1
	<%--
		RequestDispatcher rd = request.getRequestDispatcher("page2.jsp");
		rd.forward(request, response);
	--%>
	<jsp:forward page="page2.jsp">
		<jsp:param name="test" value="Hello World"/>
	</jsp:forward>
</body>
</html>



