package com.pupil.python.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class CheckAnswerPr{

	private String result; 
	private char[] mark = "000000".toCharArray();

	
	public String checkAnswer(String path, String name) throws IOException { 
		
		//Run the Python code
		ProcessBuilder codeTest = new ProcessBuilder("python",path + File.separator + name);
		codeTest.redirectErrorStream(true);
		Process process = codeTest.start(); 
		
		//Set input stream from console
		InputStream is = process.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		
		//Read output from the console , check if attendance was correct or save error
		StringBuffer tempResult = new StringBuffer();
		String line = null;
		while ((line = reader.readLine()) != null) {
			if (line.contains("Present! Ms. Justin Bieber is here!")) { 
				mark[0] = '1';
			} else {
				tempResult.append(line + "\r\n"); 
			}
		} 
		result = tempResult.toString();
		
		//Check if the class method outputted the correct thing
		BufferedReader br = new BufferedReader(new FileReader("/Users/mlee43/Desktop/PRSAVES/class_list.txt")); //TODO: !@#$
		String line1;
		while ((line1 = br.readLine()) != null) {
		   if (line1.equals("Ms. Justin Bieber , math")) { 
			   mark[1] = '1';
		   }
		}
		br.close(); 
		
		//Check if the proper methods were called 
		BufferedReader br2 = new BufferedReader(new FileReader("/Users/mlee43/Desktop/PRSAVES/class_list.txt")); //TODO: !@#$
		String line2;
		while ((line2 = br2.readLine()) != null) {
			if (line2.contains("if")) { 
				mark[2] = '1';
			} 
			if (line2.contains("for") || line2.contains("while")){ 
				mark[3] = '1';
			} 
			if (line2.contains("pupil") && line2.contains("=") && line2.contains("Classmates(") && line2.contains("student") && line2.contains("math")) {
				mark[4] = '1';
			} 
			if (line2.contains("pupil.attendance()")) { 
				mark[5] = '1'; 
			} 
			if (line2.contains("pupil.class_list()")) { 
				mark[6] = '1'; 
			}
		}
		br.close();  
		
		for(char mark:mark) { 
			if(mark == '0') { 
				break;
			} else { 
				result = "1"; 
				return result;
			}
		}
		return result;
	} 
}