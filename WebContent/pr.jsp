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

	<% 
		//Load user progress
		String progress = (String)request.getAttribute("prProgress");
	
		//Load user error
		String prError = (String)request.getAttribute("prError"); 
		String prErrorDets = (String)request.getAttribute("prErrorDets");
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
		<h1>Programming Question</h1>  
		<p>Congratulations on making it this far! Be prepared as you will face your toughest challenge yet. As long as you read the instructions carefully, you should be able to complete this question using the lessons you have just learned about classes. Good luck!</p>
		<br>
		<ol>
			<li>Using input from the file at this path "/home/ugd/mmllee/PP/PRSAVES/names.txt", define a procedure named “boys_and_girls” that uses at least one loop and at least one if statement to <u>return</u> the <u>girl</u> from the boys. A boys name will be in the form "Mr. Joe Schmoe" while a girls name has the for "Ms. Sally Schmoe".</li>
			<li>Call the boys_and_girls function and store the result in a variable named "student"</li>
			<li>Define a class named “Pupil”. All objects in Pupil must have two attributes, “name”, and “favorite_subject”.</li> 
			<li>Define a method named “attendance” that prints the string, “Present! (Name of pupil) is here!”</li>
			<li>Define a method named “class_list” that outputs the attributes of the Pupil object in the form "(name of object), (object's favorite subject)" to the "/home/ugd/mmllee/PP/PRSAVES/class_list.txt" file.</li>
			<li>Create a Pupil object named "the_girl" that uses the "student" variable retrieved from step one as the "name". Set this objects favorite_subject to "math"</li>
			<li>Call the attendance method on this object.</li>
			<li>Call the class_list method on this object.</li>  
		</ol> 
		<br> 
		<div id="upbox">
			<form action="CheckPrServlet" method="post" enctype="multipart/form-data"> 
				
				<h2 style="text-align: center">Upload your program here!</h2>
	            <p style="text-align: center">File:    <input type="file" name="file" id="file"></p><b>
				</p> 
				<p style="text-align: center"> 
					<input id="upbutton" type="submit" value="Save and submit" name="upload" id="upload">
				</p>
			</form>  
		</div>
		<br> 
		<% 
			if (progress != null){  
				if (progress.equals("1")) {	
					%> 
					<h2><img id="complete" alt="complete" src="IMAGES/complete.png">You have already complete this question</h2>
					<% 
				}
			}
			if (prError != null) { 
				%> 
				<h2 style="color:red;">Your solution was incorrect. The following message was printed on the console:</h2>
				<p style="color:red;"><%= prError %></p><br>
				<%
			}  
			if (prErrorDets != null) { 
				%> 
				<h2 style="color:red;">You did not meet the following requirements:</h2>
				<p style="color:red;"><%= prErrorDets %></p> 
				<%
			}
			
		%>  
	</div> 
	
	<div class="navigator">  
		<img id="leftNaviArrow" href="FbServlet" src="IMAGES/LeftArrow.png">
		<a id="middlebutton" href="pr_answer.html">&nbsp;&nbsp;&nbsp;&nbsp;See Answer&nbsp;&nbsp;&nbsp;&nbsp;</a> 
	</div>	

</body>
</html>