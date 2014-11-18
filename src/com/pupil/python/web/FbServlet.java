package com.pupil.python.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pupil.python.model.Fb;

@WebServlet("/FbServlet")
public class FbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public String loginInUse; 
	
    public FbServlet() {
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

		//Loads current users fb progress 
		Fb userFb = new Fb(); 
		String fbProg = userFb.loadProgress(loginInUse); //Shouldnt this require try/catch?
		
		//Forward the fb progress information to the jsp
		request.setAttribute("fbProgress", fbProg);
		RequestDispatcher view = request.getRequestDispatcher("fb.jsp");
		view.forward(request, response);
	} 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
