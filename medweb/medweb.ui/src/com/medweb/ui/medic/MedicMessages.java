package com.medweb.ui.medic;

import java.io.InputStream;
import java.util.Properties;

public enum MedicMessages {

	        UNKNOWN(""),
			EDIT_INFO_CNP("Edit_CNP"),
			EDIT_INFO_TELEFON("Edit_Telefon"),
			EDIT_INFO_ADRESA("Edit_Adresa"),
			EDIT_INITIALA("Edit_Initiala"),
			EDIT_COD_PARAFA("Edit_Parafa"),
			EDIT_NR_LICENTA("Edit_Licenta"),
			EDIT_NR_CONTRACT_CNAS("Edit_Contract_CNAS"),
			EDIT_SAVE("Edit_Save"),
	
	;
  private static final String PROP_FILE="medicMessages.properties";  
  private final String name;
  private String message;	 
	 private MedicMessages(final String string){
		 this.name=string;
		 try{  
	         InputStream is = MedicMessages.class.getResourceAsStream(PROP_FILE);  
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
