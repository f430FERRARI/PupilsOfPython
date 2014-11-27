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
	private String question;  
	private String answer;
	
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
		
		//Get answer from user and set question number
		if (request.getParameter("mc1answer") != null) {
			answer = request.getParameter("mc1answer"); 
			question = "mc1"; 
		} else if (request.getParameter("mc2answer") != null) { 
			answer = request.getParameter("mc2answer");
			question = "mc2";
		}
		
		//Check Answer
		CheckAnswerMc mcChecker = new CheckAnswerMc(); 
		String result = mcChecker.checkAnswer(answer, question);
		//TODO: mc1answer variable name incorrect. Must also include mc2.
		
		//Update course progress and mc1 progress
		CourseProgress update = new CourseProgress(); 
		Mc mcUpdate = new Mc(question);
		mcUpdate.saveProgress(result, loginInUse); 
		update.saveProgress(result, question, loginInUse); 
		
		//Direct user to appropriate page 
		if (result.equals("1")) {  
			response.setContentType("text/html");
			response.sendRedirect(question +"_correct.html");
		} else { 
			request.setAttribute(question + "Error", result); 
			RequestDispatcher view = request.getRequestDispatcher(question + ".jsp"); 
			view.forward(request, response);		 
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}