package com.medweb.ui.retete;

import java.io.InputStream;
import java.util.Properties;

public enum RetetaMessages {

	UNKNOWN(""),
	EDIT_COLUMN1_NAME("EDIT_NAME_COLUMN1"),
	EDIT_COLUMN2_NAME("EDIT_NAME_COLUMN2"),
	EDIT_COLUMN3_NAME("EDIT_NAME_COLUMN3"),
	EDIT_COLUMN4_NAME("EDIT_NAME_COLUMN4"),
	EDIT_SEARCH("EDIT_Search"),
	EDIT_RESERT("EDIT_RESERT"),
    
	EDIT_JUDETUL("Edit_Judet"),
	EDIT_LOCALITATEA("Edit_Localitate"),
	EDIT_NUME_CABINET("Edit_Nume_Cabinet"),
	EDIT_NUMAR_FISA_MEDICALA("Edit_Nr_Fisa"),
	EDIT_ADEVERINTA("Edit_Adeverinta"),
	
	EDIT_INFO1("Edit_Info1"),
	EDIT_INFO2("Edit_Info2"),
	EDIT_INFO3("Edit_Info3"),
	EDIT_INFO4("Edit_Info4"),
	EDIT_INFO5("Edit_Info5"),
	EDIT_INFO6("Edit_Info6"),
	EDIT_INFO7("Edit_Info7"),
	EDIT_INFO8("Edit_Info8"),
	EDIT_INFO9("Edit_Info9"),
	EDIT_INFO10("Edit_Info10"),
	EDIT_INFO11("Edit_Info11"),
	EDIT_INFO12("Edit_Info12"),
	EDIT_INFO13("Edit_Info13"),
	EDIT_INFO14("Edit_Info14"),
	EDIT_INFO15("Edit_Info15"),
	EDIT_INFO16("Edit_Info16"),
	EDIT_INFO17("Edit_Info17"),
	EDIT_INFO18("Edit_Info18"),
	EDIT_INFO19("Edit_Info19"),
	EDIT_INFO20("Edit_Info20"),
	EDIT_INFO21("Edit_Info21"),
	
	;
  private static final String PROP_FILE="retetaMessages.properties";  
  private final String name;
  private String message;	 
	 private RetetaMessages(final String string){
		 this.name=string;
		 try{  
	         InputStream is = RetetaMessages.class.getResourceAsStream(PROP_FILE);  
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
