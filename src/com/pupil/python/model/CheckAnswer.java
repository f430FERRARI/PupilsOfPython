package com.pupil.python.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class CheckAnswer {

	private String result; 
	private String answer; 
	
	public abstract void checkAnswer(String input);
	
	public void saveProgress() { 
		
		String line = null;
		
		FileReader fr = new FileReader("../../../../../../WebContent/SAVEFILES/questionprogress.txt"); 
		@SuppressWarnings("resource")
		BufferedReader textReader = new BufferedReader(fr);  
		
		while ((line = textReader.readLine()) != null) { 
			
			String[] parts = line.split("\\%"); 
			String idPart = parts[0];  
			//TODO: see if % is allowed as a splitter
			
			if (idPart.equals(****)) { 
				
				try{
				String toSave = "$" + result;
				FileWriter write = new FileWriter("../../../../../../WebContent/SAVEFILES/questionprogress.txt", true); 
				PrintWriter pr = new PrintWriter(write); 
				print_line.println(toSave); 
				print_line.close();  
				} 
				catch (IOException e) { 
					System.out.println(e.getMessage()); 
				}
				//TODO: add in current user id 
				//TODO: append the mcresult to the end of the user. 
				//TODO: maybe put this in the progress class
			
			}else {  
				loginStatus = false; 
			}
		}
	}  
	}
	
	public String getDescription() { 
		return result;
	}
}
