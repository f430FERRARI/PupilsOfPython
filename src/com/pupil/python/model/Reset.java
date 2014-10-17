package com.pupil.python.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Reset {
	
	public void resetProgress() throws IOException{ 
		File newlogin = new File("../../../../../../WebContent/SAVEFILES/loginlist.txt");
		FileOutputStream Stream1 = new FileOutputStream(newlogin, false); 
		Stream1.close(); 
		
		File newProgress = new File("../../../../../../WebContent/SAVEFILES/questionprogress.txt"); 
		FileOutputStream Stream2 = new FileOutputStream(newProgress, false); 
		Stream2.close();
	}
}
	

