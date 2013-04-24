package com.medweb.ui.application;

import java.io.InputStream;
import java.util.Properties;

public enum LoginMessages {

	UNKNOWN(""),
	EDIT_FORM_USER("EditForm_User"),
	EDIT_FORM_PASSWORD("EditForm_Password"),
	EDIT_FORM_LOGIN("EditForm_Login"),
	ERROR_MESSAGE_INCORECT("error1"),
	ERROR_MESSAGE_INACTIVE("error2")
	;
  private static final String PROP_FILE="loginMessages.properties";  
  private final String name;
  private String message;	 
	 private LoginMessages(final String string){
		 this.name=string;
		 try{  
	         InputStream is = LoginMessages.class.getResourceAsStream(PROP_FILE);  
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
