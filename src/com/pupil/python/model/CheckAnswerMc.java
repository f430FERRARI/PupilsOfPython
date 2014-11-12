package com.pupil.python.model;

public class CheckAnswerMc{

	public String answer = "c"; 
	
	public String checkAnswer(String input) { 
		
		if (input.equals(answer)) { 
			return "1";
		}else {
			return "0"; 
		} 
	}
}
