package com.pupil.python.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class CheckAnswerPr{

	private String result; 
	private char[] mark = "0000000".toCharArray(); 
	private String result2 = ""; 
	private String[] msg= {"Your attendance method did not print out the correct string.","Your output for the class_list method did not produce the correct string.","Your program does not contain an if statement","Your program does not contain a for loop.","Your program does not construct the correct object from the Pupil class.","Your program does not properly call the attendance method on the object.","Your program does not properly call the class_list method on the object."};
	
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
				tempResult.append(line + "<br>"); 
			}
		} 
		result = tempResult.toString();
		
		//Check if the class method outputted the correct thing
		BufferedReader br = new BufferedReader(new FileReader("/home/ugd/mmllee/PP/PRSAVES/class_list.txt")); //TODO: !@#$
		String line1;
		while ((line1 = br.readLine()) != null) {
		   if (line1.equals("Ms. Justin Bieber, math")) { 
			   mark[1] = '1';
		   } 
		}
		br.close(); 
		
		//Check if the proper methods were called 
		BufferedReader br2 = new BufferedReader(new FileReader(path + File.separator + name)); //TODO: !@#$
		String line2;
		while ((line2 = br2.readLine()) != null) {
			if (line2.contains("if")) { 
				mark[2] = '1';
			} 
			if (line2.contains("for") || line2.contains("while")){ 
				mark[3] = '1';
			} 
			if (line2.contains("the_girl") && line2.contains("=") && line2.contains("Pupil(") && line2.contains("student") && line2.contains("math")) {
				mark[4] = '1';
			}
			if (line2.contains("the_girl.attendance()")) { 
				mark[5] = '1'; 
			} 
			if (line2.contains("the_girl.class_list()")) { 
				mark[6] = '1'; 
			} 
		}
		br.close();  
		
		//Check if the criteria has been met and return the results
		int score = 0;
		for(int i=0; i < msg.length; i++) { 
			if(mark[i] == '1') {  
				score += 1;
			} 
			if(mark[i] == '0') { 
				result2 = result2 + "<br>" + msg[i];
			}
		} 
		if (score == 7) { 
			result = "1";
		}
		
		return result;
	}  
	
	public String getResult2() { 
		return result2;
	}
}