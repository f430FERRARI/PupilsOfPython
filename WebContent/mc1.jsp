<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Question #1</title> 
	<link type="text/css" rel="stylesheet" href="style.css">
</head>
<body>
	<div class="menubar"> 
		<div id="menucontent">			
			<img id="pythonLogo" src="">
			<div id="menubuttons"> 	
				<button type="button"><a href="progress.jsp">Course Progress</a></button> 
				<button type="submit" formaction="logoutServlet" formmethod="get">Logout</button>
			</div> 
		</div>
	</div>    
	
	<div class="content"> 		
		<h1>Multiple Choice Question #1</h1> 
		<p>Please select the best answer for the following question.</p>
		<form action="CheckMcServlet" method="get">  
			<p>What is a class in Python?</p> 
			<p> 
				<input type="radio" name="mcanswer" value="a">a) A keyword used to define a special variable that cannot be altered<br> 
				<input type="radio" name="mcanswer" value="b">b) A construct used to edit methods<br> 
				<input type="radio" name="mcanswer" value="c">c) The blueprint for an object<br>
				<input type="radio" name="mcanswer" value="d">d) A group of snakes	
			</p> 
			<p>
				<input type="submit" value="Save and Submit"> 
			</p>
		</form> 
	</div> 
	
	<div class="navigator">  
		<a href="progress.jsp"><img id="leftNaviArrow" src="IMAGES/LeftArrow.png"></a>
		<button type="button"><a href="mc1_answer.html">See Answer</a></button> 
		<a href="mc2.jsp"><img id="rightNaviArrow" src="IMAGES/RightArrow.png"></a>	
	</div>	 
	
</body>
</html>