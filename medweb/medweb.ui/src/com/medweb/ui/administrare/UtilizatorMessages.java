package com.medweb.ui.administrare;

import java.io.InputStream;
import java.util.Properties;

public enum UtilizatorMessages {

	UNKNOWN(""),
	COLUMN_USERNAME("Column_Username"),
	COLUMN_NUME("Column_Nume"),
	COLUMN_PRENUME("Column_Prenume"),
	COLUMN_TIP("Column_Tip"),
	EDIT_DELETE_INFO("Edit_Delete_Info"),
	
	

	;
  private static final String PROP_FILE="utilizatorMessages.properties";  
  private final String name;
  private String message;	 
	 private UtilizatorMessages(final String string){
		 this.name=string;
		 try{  
	         InputStream is = UtilizatorMessages.class.getResourceAsStream(PROP_FILE);  
	         Properties prop = new Properties();  
	         prop.load(is);
	         message=prop.getProperty(name);
	        
	             is.close();  
	      /* code to use values read from the file*/  
	       }catch(Exception e){  
	         System.out.println("Failed to read from " + PROP_FILE + " file.");  
	       }  
	 }
	public String getMessage(){
		return message;
	}
}
