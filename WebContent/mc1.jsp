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

	<% 
		//Loads user progress
		String checked = null; 
		String progress = (String)request.getAttribute("mc1Progress"); 
		if (progress != null) {
			if (progress.equals("1")) { 
				checked = "checked";
			} 
		}
		
		//Loads user error 
		String error = (String)request.getAttribute("mc1Error"); 
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
		<h1>Multiple Choice Question #1</h1> 
		<p>Please select the best answer for the following question.</p>
		<form  id="mc" action="CheckMcServlet" method="get">   
			<br>
			<h2>What is a class in Python?</h2> 
			<p> 
				<input type="radio" name="mc1answer" value="a">a) A keyword used to define a special variable that cannot be altered<br> 
				<input type="radio" name="mc1answer" value="b">b) A construct used to edit methods<br> 
				<input type="radio" name="mc1answer" value="c" <%=checked %>>c) The blueprint for an object<br>
				<input type="radio" name="mc1answer" value="d">d) A group of snakes	
			</p> 
			<p>
				<input id="submit" style="position: relative; left: 115px;" type="submit" value="Save and Submit"> 
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
		<a href="ProgressServlet"><img id="leftNaviArrow" src="IMAGES/LeftArrow.png"></a>
		<a id="middlebutton" href="mc1_answer.html">&nbsp;&nbsp;&nbsp;&nbsp;See Answer&nbsp;&nbsp;&nbsp;&nbsp;</a> 
		<a href="Mc2Servlet"><img id="rightNaviArrow" src="IMAGES/RightArrow.png"></a>	
	</div>	 
	
</body>
</html>