package com.pupil.python.model;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileWriter; 
import java.io.PrintWriter; 

public abstract class Progress { 
	
	public String progress;
	public String identifier;
		
		public void loadProgress() throws IOException{
		
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
					progress = parts[1];   
					break;
		    	}
		    }
		}      
		
		public void saveProgress(String toSave) throws IOException { 
			
			String toWrite = identifier + id + "$" + toSave;
			FileWriter write = new FileWriter("../../../../../../WebContent/SAVEFILES/questionprogress.txt", true); 
			PrintWriter print_line = new PrintWriter(write); 
			print_line.println(toWrite); 
			print_line.close(); 
		} 
		//TODO: How do you get id?


	public String getProgress(){ 
		return progress;
	}
} 