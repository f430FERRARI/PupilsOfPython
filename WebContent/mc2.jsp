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
		
		//Loads user error 
		String error = (String)request.getAttribute("mc2Error"); 
	%>
		
	<div class="menubar"> 
		<div id="menucontent">				
			<a id="pythonLogo"> >_Pupil's of Python</a>
			<div id="menubuttons"> 				
				<a href="ProgressServlet">Course Progress</a> 
				<a href="logoutServlet">Logout</a>
			</div>
		</div>
	</div>    
	
	<div class="content"> 
		<h1>Multiple Choice Question #2</h1> 
		<p>Please select the best answer for the following question.</p>
		<form id="mc" action="CheckMcServlet" method="GET">   
			<br>
			<h2>Why are classes used in Python?</h2> 
			<p> 
				<input type="radio" name="mc2answer" value="a" <%= checked %>>a) To group relevant data and functions together<br> 
				<input type="radio" name="mc2answer" value="b">b) As a means of reducing replacing if statements<br> 
				<input type="radio" name="mc2answer" value="c">c) Only as a means of debugging code<br>
				<input type="radio" name="mc2answer" value="d">d) Solely to teach special concepts in Python
			</p> 
			<p>
				<input id="submit" style="position: relative; left: 100px;" type="submit" value="Save and submit">
			</p>
		</form> 
		<br>
		<% 
			if (error != null) {
				if (error.equals("0")) {  
					%>
					<p style="color:red;">Incorrect. Please try again.</p>
					<%
				}   
			}
			if (checked == "checked"){ 
				%> 
				<h2><img id="complete" alt="complete" src="IMAGES/complete.png">You have already complete this question</h2>
				<%
			}
		%> 
	</div>  
	
	<div class="navigator">  
		<a href="McServlet"><img id="leftNaviArrow" src="IMAGES/LeftArrow.png"></a>
		<a id="middlebutton" href="mc2_answer.html">&nbsp;&nbsp;&nbsp;&nbsp;See Answer&nbsp;&nbsp;&nbsp;&nbsp;</a> 
		<a href="FbServlet"><img id="rightNaviArrow" src="IMAGES/RightArrow.png"></a>	
	</div>		
	
</body>
</html>