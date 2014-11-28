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
			<a href="index.jsp" id="pythonLogo"> >_Pupil's of Python</a>
			<div id="menubuttons"> 	
				<a href="index.jsp">Homepage</a> 
			</div>
		</div>
	</div>   
	 
	<div class="content">
		<h1>Invalid Login</h1> 
		<p>The Login was invalid because:</p>  
		<p style="color:red;"><%= message %></p>
		<p></p>  
		<div id="login2">
			<form action="LoginServlet" method="post"> 
				<p>
					User ID: <input type="text" name="id" size="15"><br> 
					   Name: <input type="text" name="name" size="15">
				</p>
				<p>
					<input id="loginbutton" type="submit" value="Login">
				</p>	
			</form>  
		</div>
	</div> 
	
</body>
</html>