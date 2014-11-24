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
		String b1;  
		String b2; 
		String b3; 
		String b4; 
		String b5; 
		String b6; 
	
		String fbProgress = (String)request.getAttribute("fbError"); 
		char[] questions = fbProgress.toCharArray(); 
		if (questions[0] == '1') { 
			b1 = "value=\"class\"";
		}
 		if (questions[1] == '1') { 
			b2 = "value=\"__init__\"";
		} if (questions[2] == '1') { 
			b3 = "value=\"self\""; 
		}  
		if (questions[3] == '1') { 
			b4 = "value=\"self\"";
		}  
		if (questions[4] == '1') { 
			b5 = "value=\"def\"";
		}  
		if (questions[5] == '1') { 
			b6="value=\"()\"";
		}
	%>
<%=b1 %> 
<%=b2 %> 
<%=b3 %> 
<%=b4 %> 
<%=b5 %> 
<%=b6 %>
	<div class="menubar">  
		<div id="menucontent">	
			<img id="pythonLogo" src=""> 
			<div id="menubuttons"> 		
				<button type="button"><a href="progress.jsp">Course Progress</a></button> 
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
	<input type="text" name="fbanswer"> Classroom: 
	     def __<input type="text" name="fbanswer">__(<input type="text" name="fbanswer" value="">, room_number, vacant=True) 
	          <input type="text" name="fbanswer">.room_number = room_number 
	          self.vacant = vacant 
	
	     <input type="text" name="fbanswer"> is_vacant(self):  
	          print self.vacant 
	
	cpsc_235 = Classroom(176, False)
	
	cpsc_235 = is_vacant<input type="text" name="fbanswer" size="5">  
				</code> 
				</pre>
			</p> 
			<input type="submit" value="Save and Submit">
		</form>
	</div> 
	
	<div class="navigator">  
		<a href="mc2.jsp"><img id="leftNaviArrow" src="IMAGES/LeftArrow.png"></a>
		<button type="button" id="middlebutton"><a href="fb_answer.html">&nbsp;&nbsp;&nbsp;&nbsp;See Answer&nbsp;&nbsp;&nbsp;&nbsp;</a></button> 
		<a href="pr.jsp"><img id="rightNaviArrow" src="IMAGES/RightArrow.png"></a>	
	</div>
	
</body>
</html>