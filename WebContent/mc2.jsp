<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Question #2</title> 
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
		
		<h1>Multiple Choice Question #2</h1> 
		<p>Please select the best answer for the following question.</p>
		<form action="" method="GET">  
			<p>Why are classes used in Python?</p> 
			<p> 
				<input type="radio" name="mcanswer" value="a">a) To group relevant data and functions together<br> 
				<input type="radio" name="mcanswer" value="b">b) As a means of reducing replacing if statements<br> 
				<input type="radio" name="mcanswer" value="c">c) Only as a means of debugging code<br>
				<input type="radio" name="mcanswer" value="d">d) Solely to teach special concepts in Python
			</p> 
			<p>
				<input type="submit" value="Check Answer">
			</p>
		</form>
	</div> 
	
	<div class="navigator">  
		<a href="mc1.jsp"><img id="leftNaviArrow" src="IMAGES/LeftArrow.png"></a>
		<button type="button"><a href="mc2_answer.html">See Answer</a></button> 
		<a href="fb.jsp"><img id="rightNaviArrow" src="IMAGES/RightArrow.png"></a>	
	</div>		
	
</body>
</html>