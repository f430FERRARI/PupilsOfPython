package com.pupil.python.model;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileWriter; 
import java.io.PrintWriter; 

public abstract class Progress { 
	
	private String progress;
	private String toSave;
	
	public class loadFile {
		
		public void loader(String qType) throws IOException{
		
		FileReader fr = new FileReader("../../../../../../WebContent/SAVEFILES/questionprogress.txt");
		BufferedReader br = new BufferedReader(fr);
		
		String identifier = assignIdentifier(qType);
		
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
		
		public void saveProgress(String qType) throws IOException { 
			
			String identifier = assignIdentifier(qType);
			
			String toWrite = identifier + toSave;
			FileWriter write = new FileWriter("../../../../../../WebContent/SAVEFILES/questionprogress.txt", true); 
			PrintWriter print_line = new PrintWriter(write); 
			print_line.println(toWrite); 
			print_line.close(); 
		} 
		//TODO: How do you get toSave?

		private String assignIdentifier(String qType) {
			if (qType.equals("cp")) { 
				return "~";
			}else if (qType.equals("mc")){ 
				return "%";
			}else if (qType.equals("fb")){ 
				return "#";
			}else if (qType.equals("pr")){ 
				return "?";
			}else{  
				return "fail";
				//TODO: Throws some sort of error
			}
		}
	}

	public String getProgress(){ 
		return progress;
	}
}
