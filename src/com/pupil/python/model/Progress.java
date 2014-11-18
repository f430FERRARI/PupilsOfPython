package com.pupil.python.model;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileWriter; 
import java.io.PrintWriter; 

public abstract class Progress { 
		
	public String identifier;
		
	public String loadProgress(String userId) throws IOException{
		
		FileReader fr = new FileReader("/Users/mlee43/Desktop/questionprogress.txt");
		BufferedReader br = new BufferedReader(fr);
			
		List<String> tmp = new ArrayList<String>(); 
		String ch;  
			
			while ((ch = br.readLine()) != null) {
			    tmp.add(ch);
			}
	
			for(int i=tmp.size()-1;i>=0;i--) {
			    String line = tmp.get(i); 
			    if (line.contains(identifier)) {  
			    	String[] parts = tmp.get(i).split(identifier);  
			    	if (parts[0].equals(userId)) { 
						return parts[1];
			    	} 
			    }
			} 
		return "F";
	}  
		
	public void saveProgress(String toSave, String userId) throws IOException { 
			
		String toWrite = userId + identifier + toSave;
		FileWriter write = new FileWriter("/Users/mlee43/Desktop/questionprogress.txt", true); 
		PrintWriter print_line = new PrintWriter(write); 
		print_line.println(toWrite); 
		print_line.close(); 
	} 

}  