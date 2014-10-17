package com.pupil.python.model;

public class CheckAnswerMc extends CheckAnswer{

	public String answer = "c"; 
	
	public String checkAnswer(String input) { 
		
		if (input.equals(answer)) { 
			return "1";
		}else {
			return "0"; 
		} 
	}
}
