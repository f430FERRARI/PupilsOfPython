package com.pupil.python.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.http.Part;

public class Pr extends Progress{

	private String prPath; 
	private String uploadResult;
	
	public String loadProgress() throws IOException { 
		
		FileReader fr = new FileReader(prPath);
		BufferedReader br = new BufferedReader(fr);
		StringBuffer stringBuffer = new StringBuffer();
		String line = null;
		while((line = br.readLine())!=null){
			stringBuffer.append(line);
		} 
		return line;
	} 
	
	public String saveFile(String path, Part filePart, String fileName) throws IOException { 
		OutputStream out = null;
	    InputStream filecontent = null;

	    try {
	        out = new FileOutputStream(new File(path + File.separator
	                + fileName));
	        filecontent = filePart.getInputStream();

	        int read = 0;
	        final byte[] bytes = new byte[1024];

	        while ((read = filecontent.read(bytes)) != -1) {
	            out.write(bytes, 0, read);
	        }
	        uploadResult = "New file " + fileName + " created at " + path;
	    } catch (FileNotFoundException fne) {
	        uploadResult = "You either did not specify a file to upload or are "
	                + "trying to upload a file to a protected or nonexistent "
	                + "location.<br/> ERROR: " + fne.getMessage();

	    } finally {
	        if (out != null) {
	            out.close();
	        }
	        if (filecontent != null) {
	            filecontent.close();
	        } 
	        return uploadResult;
	    }
	} 
	
	public String getFileName(Part part) {
	    final String partHeader = part.getHeader("content-disposition");
	    for (String content : part.getHeader("content-disposition").split(";")) {
	        if (content.trim().startsWith("filename")) {
	            return content.substring(
	                    content.indexOf('=') + 1).trim().replace("\"", "");
	        }
	    }
	    return null;
	}
}