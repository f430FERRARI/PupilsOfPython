package com.pupil.python.model;

public class CourseProgress extends Progress{
	
	String identifier = "@";  
	
	public void loadProgress(){
		
	} 
	
	public void saveProgress(){ 
		super.saveProgress(toSave);;  
		
	}
	
}
