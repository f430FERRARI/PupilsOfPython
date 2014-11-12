<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Question #1</title>
</head>
<body>
	<form action="CheckMcServlet" method="get">  
		<p>What is a class in Python?</p> 
		<p> 
			<input type="radio" name="mcanswer" value="a">a) A keyword used to define a special variable that cannot be altered<br> 
			<input type="radio" name="mcanswer" value="b">b) A construct used to edit methods<br> 
			<input type="radio" name="mcanswer" value="c">c) The blueprint for an object<br>
			<input type="radio" name="mcanswer" value="d">d) A group of snakes	
		</p> 
		<p>
			<input type="submit" value="Check Answer"> 
		</p>
	</form> 
</body>
</html>