package com.pupil.python.model;

import java.io.IOException;
import java.io.PrintWriter;

public class Reset {
	
	public void resetProgress() throws IOException{ 
		
		PrintWriter writer = new PrintWriter("/home/ugd/mmllee/PP/loginlist.txt", "UTF-8");
		writer.println("DEFAULT$DONOTDISTURB");
		writer.close(); //TODO: !@#$
		
		PrintWriter writer2 = new PrintWriter("/home/ugd/mmllee/PP/questionprogress.txt", "UTF-8");
		writer2.println("!DEFAULT$DONOTDISTURB"); //TODO:!@#$
		writer2.close();
	}
}
	

