<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Page 2</title>
</head>
<body>
	<h3>
		Welcome to Page2
	</h3>
	<h5>
		Param from last page: <%= request.getParameter("test") %>
	</h5>
</body>
</html>

