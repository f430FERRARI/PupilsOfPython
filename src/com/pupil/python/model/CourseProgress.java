package com.pupil.python.model;

import java.io.IOException;

public class CourseProgress extends Progress{
	
	public CourseProgress() { 
		identifier = ":";
	}
	
	public void saveProgress(String toSave, String question, String userId){ 
		
		try {
			
			//Loads current users current course progress
			char[] oldProgress = this.loadProgress(userId).toCharArray();
			
			//Creates a course progress for the user if it does not exist
			if (oldProgress[0] == 'F') { 
				oldProgress = "0000".toCharArray();
			}
			
			//Updates the appropriate question slot 
			if (question.equals("mc1")) { 
				if (oldProgress[0] == '0') {
					oldProgress[0] = toSave.charAt(0); 
				}
			}else if (question.equals("mc2")) { 
				if (oldProgress[1] == '0') {
					oldProgress[1] = toSave.charAt(0); 
				}
			}else if (question.equals("fb")) { 
				if (oldProgress[2] == '0') {
					oldProgress[2] = toSave.charAt(0); 
				}
			}else if (question.equals("pr")) { 
				if (oldProgress[3] == '0') {
					oldProgress[3] = toSave.charAt(0); 
				}
			}  
			
			//Saves the updated course progress to the questionprogress.txt file
			String updatedCp = new String(oldProgress);
			super.saveProgress(updatedCp, userId); 
			
		} catch (IOException e) {
			e.printStackTrace();
		}  		
	}
}