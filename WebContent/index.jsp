<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Pupil's of Python Homepage</title> 
	<link type="text/css" rel="stylesheet" href="style.css">
</head>
<body>
	<div class="menubar">  
		<div id="menucontent">	
			<a href="index.jsp" id="pythonLogo"> >_Pupil's of Python</a>
			<div id="menubuttons"> 			
				<button type="button"><a href="author.html">About the Author</a></button> 
			</div>
		</div>
	</div>   
	
	<div class="content">
		<form action="LoginServlet" method="post"> 
			<p>
				User ID: <input type="text" name="id" maxlength="6"><br> 
				   Name: <input type="text" name="name" size="22">
			</p>
			<p>
				<input type="submit" value="Login">
			</p>	
		</form> 
	</div>
</body> 

</html>