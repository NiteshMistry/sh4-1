<%@page import="com.sunbeam.sh4.jspbasics.ArithBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Arith Bean Result</title>
</head>
<body>
	<%--
		ArithBean ab = new ArithBean();
		ab.setNum1( Integer.parseInt( request.getParameter("num1") ) );
		ab.setNum2( Integer.parseInt( request.getParameter("num2") ) );
		ab.setOp( request.getParameter("op") );
		ab.calc();
		out.println("Result : " + ab.getResult());
	--%>
	<jsp:useBean id="ab" class="com.sunbeam.sh4.jspbasics.ArithBean"/>
	<jsp:setProperty name="ab"  property="*" />
	<%--
	<jsp:setProperty name="ab" property="num1" param="num1"/>
	<jsp:setProperty name="ab" property="num2" param="num2"/>
	<jsp:setProperty name="ab" property="op" param="op"/>
	--%>
	<% ab.calc(); %>
	Result : <jsp:getProperty name="ab" property="result"/>
</body>
</html>

