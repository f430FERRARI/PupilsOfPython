package com.pupil.python.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pupil.python.model.CheckAnswerFb;
import com.pupil.python.model.CourseProgress;
import com.pupil.python.model.Fb;

@WebServlet("/CheckFbAnswer")
public class CheckFbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CheckFbServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get answers from user
		String[] answer = request.getParameterValues("fbanswer"); 
		
		//Check Answer 
		CheckAnswerFb fbChecker = new CheckAnswerFb(); 
		String result = fbChecker.checkAnswer(answer); 
		
		//Update course progress and fb progress 
		CourseProgress update = new CourseProgress(); 
		Fb fbUpdate = new Fb(); 
		fbUpdate.saveProgress(result); 
		if (result.equals("111111")) { 
			update.saveProgress("1", "fb");
		} else { 
			update.saveProgress("0");
		}  
		
		//Direct user to appropriate page 
		if (result.equals("111111")) { 
			response.sendRedirect("../../../../../../WebContent/fb_correct.html");
		} else { 
			request.setAttribute("fbEroor", result); 
			RequestDispatcher view = request.getRequestDispatcher("fb_error.jsp"); 
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
