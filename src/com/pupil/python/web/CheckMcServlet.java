package com.pupil.python.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pupil.python.model.CheckAnswerMc;
import com.pupil.python.model.CourseProgress;
import com.pupil.python.model.Mc;

//TODO: Should I do one servlet for mc1 and one for mc2?

@WebServlet("/CheckMcServlet")
public class CheckMcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String loginInUse; 
	
    public CheckMcServlet() {
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
		
		//Get answer from user
		String answer = request.getParameter("mcanswer"); 
		
		//Check Answer
		CheckAnswerMc mcChecker = new CheckAnswerMc(); 
		String result = mcChecker.checkAnswer(answer);
		//TODO: mc1answer variable name incorrect. Must also include mc2.
		
		//Update course progress and mc progress
		CourseProgress update = new CourseProgress(); ; 
		Mc mcUpdate = new Mc();
		mcUpdate.saveProgress(result, loginInUse); 
		update.saveProgress(result, "mc1", loginInUse); 
		
		//Direct user to appropriate page
		if (result.equals("1")) { 
			response.sendRedirect("../../../../../../WebContent/mc1_correct.html");
		} else { 
			response.sendRedirect("../../../../../../WebContent/mc_error.html");
		}
		//TODO: Inquire into filters to fix this.
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
