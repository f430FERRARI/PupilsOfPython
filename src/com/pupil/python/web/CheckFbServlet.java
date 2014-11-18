package com.pupil.python.web;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pupil.python.model.CheckAnswerFb;
import com.pupil.python.model.CourseProgress;
import com.pupil.python.model.Fb;

@WebServlet("/CheckFbAnswer")
public class CheckFbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String loginInUse;

    public CheckFbServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get currentUser 
		Cookie[] cookies = request.getCookies();  	
		if (cookies != null) { 
			for (int i = 0; i < cookies.length; i++) { 
				Cookie cookie = cookies[i]; 
				if (cookie.getName().equals("loginId")) { 
					loginInUse = cookie.getValue();
				}
			}
		}
		
		//Get answers from user
		String[] answer = request.getParameterValues("fbanswer"); 
		
		//Check Answer 
		CheckAnswerFb fbChecker = new CheckAnswerFb(); 
		String result = fbChecker.checkAnswer(answer); 
		
		//Update course progress and fb progress 
		CourseProgress update = new CourseProgress(); 
		Fb fbUpdate = new Fb(); 
		fbUpdate.saveProgress(result, loginInUse); 
		if (result.equals("111111")) { 
			update.saveProgress("1", "fb", loginInUse);
		} else { 
			update.saveProgress("0", "fb", loginInUse);
		}  
		
		//Direct user to appropriate page 
		if (result.equals("111111")) {  
			response.setContentType("text/html");
			response.sendRedirect("fb_correct.html");
		} else { 
			request.setAttribute("fbError", result); 
			RequestDispatcher view = request.getRequestDispatcher("fb.jsp"); 
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
