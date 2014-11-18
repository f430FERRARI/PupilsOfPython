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
			<img id="pythonLogo" src="">
			<div id="menubuttons"> 
				<button type="submit" formaction="logoutServlet" formmethod="get">Logout</button>
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
		<button type="button"><a href="progress.jsp">Let's begin!</a></button>	 
	</div>

</body>
</html>