<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Arith Bean Demo</title>
</head>
<body>
	<form method="post" action="output.jsp">
		Num1 : <input type="text" name="num1"/> <br/>
		Operation : 
			<select name="op">
				<option value="+">+</option>
				<option value="-">-</option>
				<option value="*">*</option>
				<option value="/">/</option>
			</select> <br/>
		Num2 : <input type="text" name="num2"/> <br/><br/>
		<input type="submit" value="Submit"/>
	</form>
</body>
</html>
