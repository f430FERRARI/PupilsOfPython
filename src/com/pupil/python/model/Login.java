package com.pupil.python.model;


import java.io.FileWriter; 
import java.io.PrintWriter; 
import java.io.IOException; 
import java.io.FileReader; 
import java.io.BufferedReader; 

public class Login {
	private String lastId; 
	private String lastName; 
	private Boolean loginStatus; 
	private String loginResult;
	//TODO: Test to do 
	
	
	public void setName(String name){ 
		lastName = name; 
	} 
	
	public void setId(String id){ 
		lastId = id; 
	} 
	
	public void findLogin() throws IOException { 
		
		String line = null;
		
		FileReader fr = new FileReader("../../../../../../WebContent/SAVEFILES/loginlist.txt"); 
		@SuppressWarnings("resource")
		BufferedReader textReader = new BufferedReader(fr);  
		
		while ((line = textReader.readLine()) != null) { 
			
			String[] parts = line.split("\\$"); 
			String idPart = parts[0]; 
			String namePart = parts[1];
			
			if (idPart.equals(lastId)) { 
				loginStatus = true;  
				this.setUser(namePart);
				break;
			
			}else if (idPart.equals("000666")) { 
				
				loginStatus = true; 
				
				if (checkName(namePart)){ 
					loginResult = "Delete"; 
				}else {  
					loginResult = "Incorrect name. Please try again.";
				}
				break;
			
			}else {  
				loginStatus = false; 
			}
		}
	}  
	//Evaluates spaces between two lines of text 
	//evaluates every single line 
	//check loginStatus for super
	
	public void setUser(String setUserName){ 
		if (checkName(setUserName)) { 
			loginResult = lastId;
		} else { 
			loginResult = "Incorrect Name. Please try again.";
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
			if (checkValidity() == true) { 
				try{ 
					this.saveLogin();
				} 
				catch(IOException e) { 
					System.out.println(e.getMessage());
				}
			} else {
				loginResult = "Invalid login. Please only use the numbers 0-9 in your login ID.";
			}
		} 
	}
		
	public Boolean checkValidity(){ 
		try { 
	        Integer.parseInt(lastId); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    }
	    return true;
	} 
	
	public void saveLogin() throws IOException { 
		String toWrite = lastId + "$" + lastName;
		FileWriter write = new FileWriter("../../../../../../WebContent/SAVEFILES/loginlist.txt", true); 
		PrintWriter print_line = new PrintWriter(write); 
		print_line.println(toWrite); 
		print_line.close(); 
	}
	
	public String getLoginResult(){ 
		return this.loginResult;
	} 

}
