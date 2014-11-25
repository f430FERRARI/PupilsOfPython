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
				<button type="button"><a href="https://www.linkedin.com/profile/view?id=306129325&trk=nav_responsive_tab_profile">About the Author</a></button> 
			</div>
		</div>
	</div>   
	
	<div class="content">	
		<h1>Welcome to Pupil's of Python</h1>
		<div id="login">	
			<form action="LoginServlet" method="post"> 
				<p>
					User ID: <input type="text" name="id" maxlength="6" size="15"><br> 
					   Name: <input type="text" name="name" size="15">
				</p>
				<p>
					<input id="loginbutton" type="submit" value="Create Login/Login">
				</p>	
			</form>  
		</div> 
		<div id="pythons">
				<img src="IMAGES/pythonSMALL.png"> 
				<img src="IMAGES/pythonSMALL.png"> 
				<img src="IMAGES/pythonSMALL.png"> 
				<img id="pyBig" src="IMAGES/pythonBIG.png">  
		</div>   
	</div>
	<div id="des">
		<div id="descontent"> 
			<h1>Let's learn about classes!</h1> 
			<p>In this tutorial, we will be learning about classes in the Python programming language. After a few short lessons, you will be able test your knowledge about classes and write your own program using classes.</p>
		</div>  
	</div>
</body> 

</html>
