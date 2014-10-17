package com.pupil.python.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class CheckAnswer {

	private String result; 
	private String answer; 
	
	public abstract void checkAnswer(String input);
	
	public String getDescription() { 
		return result;
	}
}
