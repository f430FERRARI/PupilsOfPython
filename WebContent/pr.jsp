<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Question #4</title> 
	<link type="text/css" rel="stylesheet" href="style.css">	
</head>
<body>

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
		<h1>Programming Question</h1> 
		<p></p> 
		<form action="CheckPrServlet" method="post" enctype="multipart/form-data"> 
			File:
            <input type="file" name="file" id="file"> <b>
			</p> 
			<p> 
				<input type="submit" value="upload" name="upload" id="upload">
			</p>
		</form>
	</div> 
	
	<div class="navigator">  
		<img id="leftNaviArrow" href="FbServlet" src="IMAGES/LeftArrow.png">
		<button type="button" id="middlebutton"><a href="pr_answer.html">&nbsp;&nbsp;&nbsp;&nbsp;See Answer&nbsp;&nbsp;&nbsp;&nbsp;</a></button> 
	</div>	

</body>
</html>