package com.pupil.python.model;


import java.io.FileWriter; 
import java.io.PrintWriter; 
import java.io.IOException; 
import java.io.FileReader; 
import java.io.BufferedReader; 

public class Login {
	private String lastId; 
	private String lastName; 
	private Boolean loginStatus = false; 
	public String loginResult;	 
	
	public void setName(String name){ 
		lastName = name; 
	} 
	
	public void setId(String id){ 
		lastId = id; 
	} 
	
	public void checkReset() { 
		if (lastId.equals("000666")) { 					
			loginStatus = true; 
			
			if (lastName.equals("super")){ 
				loginResult = "Delete"; 
			}else {  
				loginResult = "Incorrect name. Please try again.";
			} //TODO: This is supposed to be outside the while loop
		}
	}
	
	public void findLogin() throws IOException { 
		
		if (loginStatus == false) {
			String line = null;
			FileReader fr = new FileReader("/home/ugd/mmllee/PP/loginlist.txt"); //TODO: !@#$
			BufferedReader textReader = new BufferedReader(fr);  
			
			while ((line = textReader.readLine()) != null) { 
					
				String[] parts = line.split("\\`"); 
				String idPart = parts[0]; 
				String namePart = parts[1];
					
				if (idPart.equals(lastId)) { 
					loginStatus = true;  
					this.setUser(namePart);
					break;
					
				}else {  
					loginStatus = false; 
				}
			} //TODO: This requires default line in txt 
		}
	}  
	
	public void setUser(String setUserName){ 
		if (checkName(setUserName)) { 
			loginResult = "Thank you for returning! You are now logged in with the ID number: " + "<span style=\"color:white;\">"+ lastId +"</span>"+".";
		} else { 
			loginResult = "The user ID already exists. The username does not match the user ID. Please enter the correct username or create a new user ID.";
		}		
	} 
	
	public Boolean checkName(String checkNameName){ 
		if (checkNameName.equals(lastName)){ 
			return true;
		}else { 
			return false; 
		}
	} 
	
	public void createLogin(){ 
		if (loginStatus == false) {
			try{ 
				this.saveLogin(); 
				loginResult = "The new account with ID number: " + "<span style=\"color:white;\">" + lastId +"</span>" + " has been successfully created."; 
			} 
			catch(IOException e) { 
				System.out.println(e.getMessage());
			}
		} 
	} 
	
	public void saveLogin() throws IOException { 
		String toWrite = lastId + "`" + lastName;
		FileWriter write = new FileWriter("/home/ugd/mmllee/PP/loginlist.txt", true); //TODO: !@#$
		PrintWriter print_line = new PrintWriter(write); 
		print_line.println(toWrite); 
		print_line.close(); 
	} //TODO: Lines may not be seperated
	
	public String getLoginResult(){ 
		return loginResult;
	} 

}
