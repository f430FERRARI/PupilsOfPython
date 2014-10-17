package com.pupil.python.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pupil.python.model.CheckAnswerMc;
import com.pupil.python.model.CourseProgress;
import com.pupil.python.model.Mc;

@WebServlet("/CheckMcServlet")
public class CheckMcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CheckMcServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get answer from user
		String answer = request.getParameter("mcanswer"); 
		
		//Check Answer
		CheckAnswerMc mcChecker = new CheckAnswerMc(); 
		String result = mcChecker.checkAnswer(answer);
		//TODO: mc1answer variable name incorrect. Must also include mc2.
		
		//Update course progress and mc progress
		CourseProgress update = new CourseProgress(); ; 
		Mc mcUpdate = new Mc();
		mcUpdate.saveProgress(result); 
		update.saveProgress(result); 
		
		//Direct user to appropriate page
		if (result.equals("1")) { 
			
		} else { 
			
		}
		//TODO: IF statement to direct result
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
