<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Question #3</title> 
	<link type="text/css" rel="stylesheet" href="style.css">
</head>
<body>

	<% 
		//Declare variables for the blanks
		String b1 = "";  
		String b2 = ""; 
		String b3 = ""; 
		String b4 = ""; 
		String b5 = ""; 
		String b6 = ""; 
	
		//Load user errors
		String fbError = (String)request.getAttribute("fbError"); 
		if (fbError != null) { 
			char[] questions = fbError.toCharArray(); 
			if (questions[0] == '1') { 
				b1 = "value=\"class\"";
			} else { 
				b1 = "style=\"color:red;\" value=\"Incorrect\"";
			} if (questions[1] == '1') { 
				b2 = "value=\"init\"";
			} else {  
				b2 = "style=\"color:red;\" value=\"Incorrect\"";
			} if (questions[2] == '1') { 
				b3 = "value=\"self\""; 
			} else { 
				b3 = "style=\"color:red;\" value=\"Incorrect\"";
			} if (questions[3] == '1') { 
				b4 = "value=\"self\"";
			} else { 
				b4 = "style=\"color:red;\" value=\"Incorrect\"";
			} if (questions[4] == '1') { 
				b5 = "value=\"def\"";
			} else { 
				b5 = "style=\"color:red;\" value=\"Incorrect\"";
			} if (questions[5] == '1') { 
				b6="value=\"()\"";
			} else { 
				b6 = "style=\"color:red;\" value=\"Incorrect\"";
			} 
		} 
		
		//Load user progress
		String progress = (String)request.getAttribute("fbProgress"); 
		if (progress != null) { 
			char[] questions = progress.toCharArray(); 
			if (questions[0] != 'F') {
				if (questions[0] == '1') { 
					b1 = "value=\"class\"";
				} if (questions[1] == '1') { 
					b2 = "value=\"__init__\"";
				} if (questions[2] == '1') { 
					b3 = "value=\"self\""; 
				} if (questions[3] == '1') { 
					b4 = "value=\"self\"";
				} if (questions[4] == '1') { 
					b5 = "value=\"def\"";
				} if (questions[5] == '1') { 
					b6="value=\"()\"";
				}  
			}
		}
	%>

	<div class="menubar">  
		<div id="menucontent">	
			<a id="pythonLogo"> >_Pupil's of Python</a>
			<div id="menubuttons"> 		
				<button type="button"><a href="ProgressServlet">Course Progress</a></button> 
				<button type="button"><a href="logoutServlet">Logout</a></button>
			</div>
		</div>
	</div>    
	
	<div class="content"> 
		 
		 <h1>Fill-in-the-Blank</h1> 
		 <p>For the following exercise, fill in the blanks with the appropriate keyword. Press "Check Answer" to check and save your answer.</p>
		 <form action="CheckFbAnswer" method="GET">  
			<p> 
				<pre> 
				<code> 
	<input type="text" name="fbanswer" size="10"<%= b1 %>> Classroom: 
	     def __<input type="text" name="fbanswer" size="10"<%=b2 %> >__(<input type="text" name="fbanswer" size="10"<%=b3 %>>, room_number, vacant=True) 
	          <input type="text" name="fbanswer" size="10"<%=b4 %> >.room_number = room_number 
	          self.vacant = vacant 
	
	     <input type="text" name="fbanswer" size="10"<%=b5 %>> is_vacant(self):  
	          print self.vacant 
	
	cpsc_235 = Classroom(176, False)
	
	cpsc_235 = is_vacant<input type="text" name="fbanswer" size="10" <%=b6 %>>  
				</code> 
				</pre>
			</p> 
			<input id="submit" style="position: relative; left: 350px;" type="submit" value="Save and Submit">
		</form> 
		<br> 
		<% 
			if (progress != null){  
				if (progress.equals("111111")) { 
					%> 
					<h2><img id="complete" alt="complete" src="IMAGES/complete.png">You have already complete this question</h2>
					<% 
				}
			} 
			if (fbError != null) { 
				if (!fbError.equals("111111")) { 
					%> 
					<p style="color:red;">Incorrect. There was one or more errors.</p>
					<% 
				}
			}
		%> 
	</div> 
	
	<div class="navigator">  
		<a href="Mc2Servlet"><img id="leftNaviArrow" src="IMAGES/LeftArrow.png"></a>
		<button type="button" id="middlebutton"><a href="fb_answer.html">&nbsp;&nbsp;&nbsp;&nbsp;See Answer&nbsp;&nbsp;&nbsp;&nbsp;</a></button> 
		<a href="ProgressServlet"><img id="rightNaviArrow" src="IMAGES/RightArrow.png"></a>	
	</div>
	
</body>
</html>