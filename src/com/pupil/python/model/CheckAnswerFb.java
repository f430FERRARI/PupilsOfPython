package com.pupil.python.model;

public class CheckAnswerFb{

	char[] tempResult = "000000".toCharArray();
	
	String[] answer = { 
		"class", "init", "self", "self", "def", "()"
	};
	
	public String checkAnswer(String[] input){ 
		
		//Checks and updates the result of each blank
		if (input[0].trim().equals(answer[0])) { 
			tempResult[0] = '1';
		}else{ 
			tempResult[0] = '0'; 
		} 
		if (input[1].trim().equals(answer[1])) { 
			tempResult[1] = '1';
		}else{ 
			tempResult[1] = '0'; 
		}
		if (input[2].trim().equals(answer[2])) { 
			tempResult[2] = '1';
		}else{ 
			tempResult[2] = '0'; 
		} 
		if (input[3].trim().equals(answer[3])) { 
			tempResult[3] = '1';
		}else{ 
			tempResult[3] = '0'; 
		} 
		if (input[4].trim().equals(answer[4])) { 
			tempResult[4] = '1';
		}else{ 
			tempResult[4] = '0'; 
		} 
		if (input[5].trim().equals(answer[5])) { 
			tempResult[5] = '1';
		}else{ 
			tempResult[5] = '0'; 
		} 
		
		//Turns result into a string and returns it  
		String result = new String(tempResult); 
		return result;
	}
} 
