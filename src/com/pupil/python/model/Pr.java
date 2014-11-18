package com.pupil.python.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Pr extends Progress{

	private String prPath; 
	String identifier = "?"; 
	
	public void setPrPath(String userId) { 
		prPath = "/Users/mlee43/Desktop/PRSAVES/" + userId + ".py"; 
	} 
	
	public String loadProgress() throws IOException { 
		
		FileReader fr = new FileReader(prPath);
		BufferedReader br = new BufferedReader(fr);
		StringBuffer stringBuffer = new StringBuffer();
		String line = null;
		while((line = br.readLine())!=null){
			stringBuffer.append(line);
		} 
		return line;
		
	} 
	
	public void saveProgress(String toSave) throws IOException { 
		
		FileWriter write = new FileWriter(prPath, false); 
		PrintWriter print_line = new PrintWriter(write); 
		print_line.println(toSave); 
		print_line.close();
	} 
	
	public String getPrPath() { 
		return prPath;
	}
}