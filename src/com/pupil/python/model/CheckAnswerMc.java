package com.pupil.python.model;

public class CheckAnswerMc{

	public String answer1 = "c";  
	public String answer2 = "a";
	
	public String checkAnswer(String input, String question) { 
		
		if (question.equals("mc1")){
			if (input.equals(answer1)) { 
				return "1";
			}else {
				return "0"; 
			}  
		} else { 
			if (input.equals(answer2)) { 
				return "1"; 
			} else { 
				return "0";
			}
		}
	}
}
