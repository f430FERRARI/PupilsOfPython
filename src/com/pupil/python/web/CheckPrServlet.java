package com.pupil.python.web;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.pupil.python.model.CheckAnswerPr;
import com.pupil.python.model.CourseProgress;
import com.pupil.python.model.Pr;

@WebServlet("/CheckPrServlet") 
@MultipartConfig //Watch this 
public class CheckPrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;  
	private String foldPath = "/Users/mlee43/Desktop/PRSAVES";  //TODO: !@#$
	private String fileName;
	private String loginInUse;  
	private String codeLoco; 
	private String uploadResult;
    	
    public CheckPrServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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

	    //Get file and filename
	    final Part filePart = request.getPart("file");

	    //Get file name and save uploaded file 
	    Pr prSaver = new Pr();  
	    fileName = loginInUse + prSaver.getFileName(filePart);
	    uploadResult = prSaver.saveFile(foldPath, filePart, fileName);
	    
	    //Delegate based on upload result
	    if (uploadResult.equals("1")){
		    //Check programming answer 
		    CheckAnswerPr prChecker = new CheckAnswerPr(); 
		    String result = prChecker.checkAnswer(foldPath, fileName);
		
			//Update course progress
			CourseProgress update = new CourseProgress(); 
			if (result.equals("1")) { 
				update.saveProgress("1", "pr", loginInUse);
			} else { 
				update.saveProgress("0", "pr", loginInUse);
			}
			
			//Direct user based on answer result 
			if (result.equals("1")) { 
				response.setContentType("text/html"); 
				response.sendRedirect("pr_correct.html"); 
			} else { 
				request.setAttribute("prError", result); 
				RequestDispatcher view = request.getRequestDispatcher("pr.jsp"); 
				view.forward(request, response);
			}  
	    } else { 
	    	request.setAttribute("uploadError", prSaver.getUploadResult()); 
			RequestDispatcher view = request.getRequestDispatcher("pr.jsp"); 
			view.forward(request, response);
	    }
	}  
	//TODO: why doesnt it go to do the check

}
 
