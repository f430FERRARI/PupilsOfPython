<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Course Progress</title> 
	<link type="text/css" rel="stylesheet" href="style.css">
</head>
<body>   
	
	<% 
		//Declare the variable for each question 
		String mc1 = null; 
		String mc2 = null; 
		String fb = null; 
		String pr = null;  		
		
		//Set paths to images 
		String image1 = "<img id=\"complete\" alt=\"check\" src=\"IMAGES/complete.png\">"; 
		String image2 = "<img id=\"complete\" alt=\"uncheck\" src=\"IMAGES/incomplete.png\">";
		
		//Set the image based on the result of each question
		String cp = (String)request.getAttribute("courseProgress"); 		
		if(cp != null) {
			char[] questions = cp.toCharArray(); 
			if(questions[0] != 'F') { 
				if (questions[0] == '1') { 
					mc1 = image1; 
				} else { 
					mc1 = image2;
				} if (questions[1] == '1') { 
					mc2 = image1; 
				} else { 
					mc2 = image2;
				} if (questions[2] == '1') { 
					fb = image1; 
				} else { 
					fb = image2;
				} if (questions[3] == '1') { 
					pr = image1; 
				} else { 
					pr = image2;  
				}  
			} else { 
				mc1 = image2; 
				mc2 = image2; 
				fb = image2; 
				pr = image2; 
		}} else { 
			mc1 = image2; 
			mc2 = image2; 
			fb = image2; 
			pr = image2; 
		} 
		
	%> 
		
	<div class="menubar"> 
		<div id="menucontent">		
			<a id="pythonLogo"> >_Pupil's of Python</a>
			<div id="menubuttons"> 				
				<button type="button"><a href="logoutServlet">Logout</a></button>
			</div>
		</div>
	</div>    
	
	<div class="content">  
		<h1>Course Progress</h1> 
		<p>There is always plenty to learn about classes. Here is your course progress thus far. Take your time and make sure you have these concepts down!</p> 
		<br>  
		<div style="text-align: center;">
			<p><img alt="study" src="IMAGES/study.png" id="complete">&nbsp;&nbsp;<a href="concept1.html">What is a Class?</a></p>
			<p><img alt="study" src="IMAGES/study.png" id="complete">&nbsp;&nbsp;<a href="concept2.html">Attributes, Methods, __init__ and Self</a></p>
			<p><img alt="study" src="IMAGES/study.png" id="complete">&nbsp;&nbsp;<a href="concept3.html">Class Example</a></p> 
			<p><%= mc1 %>&nbsp;&nbsp;<a href="McServlet">Multiple Choice #1</a></p> 
			<p><%= mc2 %>&nbsp;&nbsp;<a href="Mc2Servlet">Multiple Choice #2</a></p>
			<p><%= fb %>&nbsp;&nbsp;<a href="FbServlet">Fill-in-the-Blank</a></p>
			<p><%= pr %>&nbsp;&nbsp;<a href="pr.jsp">Programming Question</a></p> 
		</div>
	</div> 
	
	<div class="navigator">  
		<button type="button" id="middlebutton"><a href="concept1.html">To first lesson</a></button> 
	</div> 
	 
</body>
</html>