package com.pupil.python.model;

import java.io.IOException;

public class CourseProgress extends Progress{
	
	String identifier = "@";   
	
	public void saveProgress(String toSave, String question){ 
		try {
			
			char[] oldProgress = this.loadProgress().toCharArray();
			
			if (question.equals("mc1")) { 
				oldProgress[0] = toSave;
			}else if (question.equals("mc2")) { 
				oldProgress[1] = toSave;

			}else if (question.equals("fb")) { 
				oldProgress[2] = toSave;

			}else if (question.equals("pr")) { 
				oldProgress[3] = toSave;
			} else { 
				System.out.println("epic fail"); //TODO: See if this method works
			} 
			
			super.saveProgress(oldProgress.toString()); 
			
		} catch (IOException e) {
			e.printStackTrace();
		}  		
	}
}
