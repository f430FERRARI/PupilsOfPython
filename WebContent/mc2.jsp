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

	<%
		//Loads user progress
		String checked = null; 
		String progress = (String)request.getAttribute("mc2Progress"); 
		if (progress != null) {
			if (progress.equals("1")) { 
				checked = "checked";
			}  
		} 
		
		//Comminucates user error
		String result = null; 
		String error = (String)request.getAttribute("mc2Error"); 
		if (error != null) {
			if (error.equals("0")) { 
				result =  "Incorrect. Please \try again.";
			}   
		}
	%>
		
	<div class="menubar"> 
		<div id="menucontent">				
			<a href="index.jsp" id="pythonLogo"> >_Pupil's of Python</a>
			<div id="menubuttons"> 				
				<button type="button"><a href="progress.jsp">Course Progress</a></button> 
				<button type="button"><a href="logoutServlet">Logout</a></button>
			</div>
		</div>
	</div>    
	
	<div class="content"> 
		
		<h1>Multiple Choice Question #2</h1> 
		<p>Please select the best answer for the following question.</p>
		<form action="CheckMcServlet" method="GET">  
			<p>Why are classes used in Python?</p> 
			<p> 
				<input type="radio" name="mc2answer" value="a" <%= checked %>>a) To group relevant data and functions together<br> 
				<input type="radio" name="mc2answer" value="b">b) As a means of reducing replacing if statements<br> 
				<input type="radio" name="mc2answer" value="c">c) Only as a means of debugging code<br>
				<input type="radio" name="mc2answer" value="d">d) Solely to teach special concepts in Python
			</p> 
			<p>
				<input type="submit" value="Check Answer">
			</p>
		</form>
	</div>  
	<br>
		<p><%= result %></p>
	<div class="navigator">  
		<a href="McServlet"><img id="leftNaviArrow" src="IMAGES/LeftArrow.png"></a>
		<button type="button" id="middlebutton"><a href="mc2_answer.html">&nbsp;&nbsp;&nbsp;&nbsp;See Answer&nbsp;&nbsp;&nbsp;&nbsp;</a></button> 
		<a href="FbServlet"><img id="rightNaviArrow" src="IMAGES/RightArrow.png"></a>	
	</div>		
	
</body>
</html>