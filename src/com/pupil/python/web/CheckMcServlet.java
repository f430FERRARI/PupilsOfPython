package com.pupil.python.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pupil.python.model.CheckAnswerMc;

@WebServlet("/CheckMcServlet")
public class CheckMcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CheckMcServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String answer = request.getParameter("mcanswer"); 
		CheckAnswerMc mcChecker = new CheckAnswerMc(); 
		//TODO: mc1answer variable name incorrect. Must also include mc2.
		
		mcChecker.checkAnswer(answer); 
		
		if (mcChecker.getDescription().equals("1")) { 
			
		} else { 
			
		}
		//TODO: IF statement to direct result
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
