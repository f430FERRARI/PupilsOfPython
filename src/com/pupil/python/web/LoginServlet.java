package com.pupil.python.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pupil.python.model.Login;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get username and ID from the login page
		String currentId = request.getParameter("id");  
		String currentName = request.getParameter("name"); 
		Login currentUser = new Login();  
		currentUser.setId(currentId);
		currentUser.setName(currentName); 
		
		//Check if user wants to reset 
		currentUser.checkReset();
		
		//Try to find the login information and set as user if it exists
		try{
				currentUser.findLogin();   
		} 
		catch(IOException e){ 
			System.out.println("epic fail");
		}
		
		//Create new login if the current information is not found
		currentUser.createLogin(); 
		
		//Retrieve result from login process
		String loginResult = currentUser.getLoginResult();
		
		//Forward login results to appropriate feedback page
		request.setAttribute("loginInfo", loginResult);  
		RequestDispatcher view;
		if (loginResult.contains(currentId)) { //May not find currentId because it is called last id in login.java
			//Create login cookie that expires in 3 hours
			Cookie loginCookie = new Cookie("loginId", currentId); 
			loginCookie.setMaxAge(180*60); 
			response.addCookie(loginCookie); //Response may be added incorrectly 
			view = request.getRequestDispatcher("login_success.jsp");  
			view.forward(request, response);		
		} else if (loginResult.equals("Delete")) { 
			response.setContentType("text/html"); 
			response.sendRedirect("reset.html");
		} else { 
			view = request.getRequestDispatcher("login_failure.jsp"); 
			view.forward(request, response);
		}
	}

}
