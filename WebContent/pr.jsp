<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Question #4</title> 
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
		<h1>Programming Question</h1> 
		<p></p> 
		<form action="CheckPrServlet" method="post" > 
			<p>Pupils.py:<br> 
				<textarea name="code"></textarea>
			</p> 
			<p> 
				<input type="submit" value="Save and submit">
			</p>
		</form>
	</div> 
	
	<div class="navigator">  
		<img id="leftNaviArrow" href="fb.jsp" src="IMAGES/LeftArrow.png">
		<button type="button"><a href="pr_answer.html">See Answer</a></button> 
	</div>	

</body>
</html>