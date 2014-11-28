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

@WebServlet("/Mc2Servlet")
public class Mc2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public String loginInUse;
    private String mc2Prog;

    
    public Mc2Servlet() {
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
		
		//Loads current users mc2 progress 
		CourseProgress userMc2 = new CourseProgress(); 
		String prog = userMc2.loadProgress(loginInUse); 
		char[] questions = prog.toCharArray();  
		
		if (questions[0] == 'F'){ 
			mc2Prog = "0";
		} else {
			if (questions[1] == '1') { 
				mc2Prog = "1";
			} else { 
				mc2Prog = "0";
			}
		} 
		
		//Forward the mc2 progress information to the jsp 
		request.setAttribute("mc2Progress", mc2Prog); 
		RequestDispatcher view = request.getRequestDispatcher("mc2.jsp"); 
		view.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
