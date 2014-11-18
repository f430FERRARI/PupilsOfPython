package com.pupil.python.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pupil.python.model.Reset;

@WebServlet("/ResetServlet")
public class ResetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ResetServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Reset page
		Reset confirmed = new Reset(); 
		confirmed.resetProgress(); 
		
		//Redirect user to successful reset page
		response.setContentType("text/html");
		response.sendRedirect("reset_success.html");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
