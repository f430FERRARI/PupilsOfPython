<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Unsuccessful Login</title> 
	<link type="text/css" rel="stylesheet" href="style.css">
</head>
<body>   
	
	<% 
		String message = (String)request.getAttribute("loginInfo"); 
	%> 
	
	<div class="menubar"> 
		<div id="menucontent">	
			<img id="pythonLogo" src="">
			<div id="menubuttons"> 	
				<button type="button"><a href="index.jsp">Homepage</a></button> 
			</div>
		</div>
	</div>   
	 
	<div class="content">
		<h1>Invalid Login</h1> 
		<p>The Login was invalid because: </p>  
		<p><%= message %></p>
		<p>Please try again</p>  
		<form action="LoginServlet" method="post"> 
			<p>
				User ID: <input type="text" name="id"><br> 
				   Name: <input type="text" name="name" size="22">
			</p>
			<p>
				<input type="submit" value="Login">
			</p>	
		</form> 
	</div> 
	
</body>
</html>