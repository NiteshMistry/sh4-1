<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Include Directive</title>
</head>
<body>
	<table width="100%">
		<tr height="100px" style="text-align: center;">
			<td>
				<%@ include file="header.jsp" %>
			</td>
		</tr>
		<tr height="400px">
			<td>
				Welcome to my bookshop.
				...
			</td>
		</tr>
		<tr height="100px" style="text-align: center;">
			<td>
				<%@ include file="footer.jsp" %>
			</td>
		</tr>
	</table>
</body>
</html>