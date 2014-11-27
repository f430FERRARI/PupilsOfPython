<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Success!</title> 
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
				<a href="logoutServlet">Logout</a>
			</div>
		</div>	
	</div>   
	 
	<div class="content"> 
		<% 
			if(message.contains("!")) { 
				%> 
				<h1>Welcome back!</h1>
				<% 
			} else { 
				%> 
				<h1>Congratulations! You have just created a new account.</h1> 
				<%
			}
		%>
		<p><%= message %></p> 
	</div>  
	
	<div class="navigator"> 
		<a id="middlebutton" href="ProgressServlet">&nbsp;&nbsp;Let's begin!&nbsp;&nbsp;</a>	 
	</div>

</body>
</html>