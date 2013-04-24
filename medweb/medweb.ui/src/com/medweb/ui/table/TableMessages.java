package com.medweb.ui.table;

import java.io.InputStream;
import java.util.Properties;

public enum TableMessages {

	UNKNOWN(""),
	EDIT_COLUMN("Edit_Column"),
	EDIT_CRITERIA("Edit_Criteria"),
	EDIT_INFO("Edit_Info"),
	EDIT_ADD("Edit_Add"),
	EDIT_ERROR_COLUMN("Error_Column"),
	EDIT_ERROR_CRITERIA("Error_Criteria"),
	EDIT_ERROR_VALUE("Error_Value"),
	EDIT_ERROR_NO_FILTER("Error_NoFilterActive"),
	EDIT_FILTERS("Edit_Filters"),
	EDIT_NR_OF_FILTERS_TEXT("Edit_Nr_Of_Filters"),
	EDIT_VALUE("Edit_Value"),
	EDIT_REMOVE("Edit_Remove"),
	EDIT_REMOVE_FILTER("Edit_Remove_Filter")
	;
  private static final String PROP_FILE="tableMessages.properties";  
  private final String name;
  private String message;	 
	 private TableMessages(final String string){
		 this.name=string;
		 try{  
	         InputStream is = TableMessages.class.getResourceAsStream(PROP_FILE);  
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
