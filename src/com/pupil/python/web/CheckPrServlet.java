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
	private String loginInUse;  
	private String codeLoco;
    
	private final static Logger LOGGER = Logger.getLogger(CheckPrServlet.class.getCanonicalName()); //Not sure if this is needed
	
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

		response.setContentType("text/html;charset=UTF-8");

	    // Create path components to save the file
	    final String path = request.getParameter("destination");
	    final Part filePart = request.getPart("file");
	    final String fileName = getFileName(filePart);

	    OutputStream out = null;
	    InputStream filecontent = null;
	    final PrintWriter writer = response.getWriter();

	    try {
	        out = new FileOutputStream(new File(path + File.separator
	                + fileName));
	        filecontent = filePart.getInputStream();

	        int read = 0;
	        final byte[] bytes = new byte[1024];

	        while ((read = filecontent.read(bytes)) != -1) {
	            out.write(bytes, 0, read);
	        }
	        writer.println("New file " + fileName + " created at " + path);
	        LOGGER.log(Level.INFO, "File{0}being uploaded to {1}", 
	                new Object[]{fileName, path});
	    } catch (FileNotFoundException fne) {
	        writer.println("You either did not specify a file to upload or are "
	                + "trying to upload a file to a protected or nonexistent "
	                + "location.");
	        writer.println("<br/> ERROR: " + fne.getMessage());

	        LOGGER.log(Level.SEVERE, "Problems during file upload. Error: {0}", 
	                new Object[]{fne.getMessage()});
	    } finally {
	        if (out != null) {
	            out.close();
	        }
	        if (filecontent != null) {
	            filecontent.close();
	        }
	        if (writer != null) {
	            writer.close();
	        }
	    }
	}

	private String getFileName(final Part part) {
	    final String partHeader = part.getHeader("content-disposition");
	    LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
	    for (String content : part.getHeader("content-disposition").split(";")) {
	        if (content.trim().startsWith("filename")) {
	            return content.substring(
	                    content.indexOf('=') + 1).trim().replace("\"", "");
	        }
	    }
	    return null;
	}

		
		
/*		
		//Set and get path 
		Pr pr = new Pr();    
		pr.setPrPath(loginInUse); 
		codeLoco = pr.getPrPath();
		
		//Get answer from user  
		request.setCharacterEncoding("UTF-8");
		String answer = request.getParameter("code"); 
		
		//Save PR answer to .py file 
		pr.saveProgress(answer);
		
		//Check answer 
		CheckAnswerPr prChecker = new CheckAnswerPr(); 
		String result = prChecker.checkAnswer(codeLoco); 
		
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
*/
	}
 
