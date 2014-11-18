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

@WebServlet("/ProgressServlet")
public class ProgressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public String loginInUse;
	
    public ProgressServlet() {
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
	
		//Loads current users course progress 
		CourseProgress userCourse = new CourseProgress(); 
		String courseProg = userCourse.loadProgress(loginInUse); 
		
		//Forward the progress information to the jsp 
		request.setAttribute("courseProgress", courseProg); 
		RequestDispatcher view = request.getRequestDispatcher("progress.jsp"); 
		view.forward(request, response);
	} 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
