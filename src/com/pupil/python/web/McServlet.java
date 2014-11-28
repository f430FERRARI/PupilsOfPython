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
import com.pupil.python.model.Mc;

@WebServlet("/McServlet")
public class McServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public String loginInUse; 
    private String mc1Prog;
	
    public McServlet() {
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
		
		//Loads current users mc1 progress 
		CourseProgress userMc1 = new CourseProgress(); 
		String prog = userMc1.loadProgress(loginInUse);  
		char[] questions = prog.toCharArray();  
		
		if (questions[0] == 'F'){ 
			mc1Prog = "0";
		} else {
			if (questions[0] == '1') { 
				mc1Prog = "1";
			} else { 
				mc1Prog = "0";
			}
		} 
		
		//Forward the mc1 progress information to the jsp 
		request.setAttribute("mc1Progress", mc1Prog); 
		RequestDispatcher view = request.getRequestDispatcher("mc1.jsp"); 
		view.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
