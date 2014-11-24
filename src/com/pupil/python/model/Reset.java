package com.pupil.python.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class Reset {
	
	public void resetProgress() throws IOException{ 
		
		PrintWriter writer = new PrintWriter("/Users/mlee43/Desktop/loginlist.txt", "UTF-8");
		writer.println("DEFAULT$DONOTDISTURB");
		writer.close(); //TODO: !@#$
		
		PrintWriter writer2 = new PrintWriter("/Users/mlee43/Desktop/questionprogress.txt", "UTF-8");
		writer2.println("!DEFAULT$DONOTDISTURB"); //TODO:!@#$
		writer2.close();
	}
}
	

