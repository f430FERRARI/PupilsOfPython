package com.pupil.python.model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CheckAnswerMc extends CheckAnswer{

	private String result = "0";
	private String answer = "c"; 
	
	public void checkAnswer(String input) { 
		if (input.equals(answer)) { 
			result = "1";
		}   
		
		this.saveProgress();
	} 
	
	public void saveProgress() throws IOException { 
		
	}
}
