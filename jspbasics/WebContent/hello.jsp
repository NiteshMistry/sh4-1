<%@ page language="java" contentType="text/html" %>
<%@ page import="java.util.*" %>
<html>
	<head>
		<title>Hello JSP</title>
	</head>
	<body>
		<!-- Client Side commnet -->
		<%-- Server Side commnet --%>
		<%!
			private int count = 0;
			public void jspInit() {
				System.out.println("jspInit() called ...");
			}
			public void jspDestroy() {
				System.out.println("jspDestroy() called ...");
			}
		%>
		<h1>Hello JSP</h1>
		<%
			count++;
			if(count % 2 == 0) {
		%>
			<h3> Even Number : <%= count %> </h3>
		<% } else { %>
			<h3> Odd Number : <%= count %> </h3>
		<% } %>
		<%
			Date d = new Date();
			out.println("NOW : " + d.toString());			
		%>		
	</body>
</html>



