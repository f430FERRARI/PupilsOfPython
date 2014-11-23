package com.pupil.python.model;

public class Mc extends Progress{
	
	 public Mc(String question) { 
		 
		 if (question.equals("mc1")) {
			 identifier = "%";
		 } else if (question.equals("mc2")) { 
			 identifier = "^";
		 }
	}
	
}
