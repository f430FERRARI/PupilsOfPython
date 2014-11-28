package com.pupil.python.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pupil.python.model.CourseProgress;

@WebServlet("/PrServlet")
public class PrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String loginInUse;  
    private String prProg;
	
    public PrServlet() {
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
		
		//Loads current users PR progress 
		CourseProgress userPr = new CourseProgress(); 
		String prog = userPr.loadProgress(loginInUse);  
		char[] questions = prog.toCharArray();  
		
		if (questions[0] == 'F'){ 
			prProg = "0";
		} else {
			if (questions[3] == '1') { 
				prProg = "1";
			} else { 
				prProg = "0";
			}
		} 
		
		//Forward the PR progress information to the jsp 
		request.setAttribute("prProgress", prProg); 
		RequestDispatcher view = request.getRequestDispatcher("pr.jsp"); 
		view.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
