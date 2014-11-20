package com.pupil.python.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pupil.python.model.Mc;

@WebServlet("/Mc2Servlet")
public class Mc2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public String loginInUse;
	
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
		Mc userMc2 = new Mc("mc2"); 
		String mc2Prog = userMc2.loadProgress(loginInUse); 
		
		//Forward the mc2 progress information to the jsp 
		request.setAttribute("mc2Progress", mc2Prog); 
		RequestDispatcher view = request.getRequestDispatcher("mc2.jsp"); 
		view.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
