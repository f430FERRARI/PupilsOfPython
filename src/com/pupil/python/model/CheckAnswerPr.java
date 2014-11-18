package com.pupil.python.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class CheckAnswerPr{

	private String result; 

	
	public String checkAnswer(String path) throws IOException { 
		
		//Run the Python code
		ProcessBuilder codeTest = new ProcessBuilder("python",path);
		codeTest.redirectErrorStream(true);
		Process process = codeTest.start(); 
		
		//Set input stream from console
		InputStream is = process.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		
	    //Read output from the console  
		StringBuffer tempResult = new StringBuffer();
		String line = null;
		while ((line = reader.readLine()) != null) {
		   tempResult.append(line + "\r\n");
		} 
		result = tempResult.toString();
	    return result; 
	}
} 