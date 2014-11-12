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
		
		FileReader fr = new FileReader("../../../../../../WebContent/SAVEFILES/questionprogress.txt");
		BufferedReader br = new BufferedReader(fr);
		
		List<String> tmp = new ArrayList<String>(); 
		String ch;  
		
		    do {
		        ch = br.readLine();
		        tmp.add(ch);
		    } while (ch != null);

		    for(int i=tmp.size()-1;i>=0;i--) {
		    	String line = tmp.get(i); 
		    	if (line.contains(identifier)) {  
		    		String[] parts = tmp.get(i).split("\\$");  
		    		String[] moreParts = parts[0].split(identifier);  
		    		if (moreParts[1].equals(userId)) { 
						return parts[1];
		    		} 
		    	}
		    }
		} //TODO: Must return a string      
		
		public void saveProgress(String toSave, String userId) throws IOException { 
			
			String toWrite = identifier + userId + "$" + toSave;
			FileWriter write = new FileWriter("../../../../../../WebContent/SAVEFILES/questionprogress.txt", true); 
			PrintWriter print_line = new PrintWriter(write); 
			print_line.println(toWrite); 
			print_line.close(); 
		} 

} 