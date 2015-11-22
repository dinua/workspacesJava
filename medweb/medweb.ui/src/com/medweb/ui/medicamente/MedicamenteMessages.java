package com.medweb.ui.medicamente;

import java.io.InputStream;
import java.util.Properties;

public enum MedicamenteMessages {

	UNKNOWN(""),
	EDIT_SUBLISTA_INFO_A1("EDIT_INFO1_A"),
	EDIT_SUBLISTA_INFO_A2("EDIT_INFO2_A"),
	EDIT_SUBLISTA_INFO_A3("EDIT_INFO3_A"),
	
	EDIT_SUBLISTA_INFO_B1("EDIT_INFO1_B"),
	EDIT_SUBLISTA_INFO_B2("EDIT_INFO2_B"),
	EDIT_SUBLISTA_INFO_B3("EDIT_INFO3_B"),
	
	EDIT_SUBLISTA_INFO1_C1("EDIT_INFO1_C1"),
	EDIT_SUBLISTA_INFO2_C1("EDIT_INFO2_C1"),
	EDIT_SUBLISTA_INFO3_C1("EDIT_INFO3_C1"),
	EDIT_SUBLISTA_INFO4_C1("EDIT_INFO4_C1"),
	EDIT_SUBLISTA_INFO5_C1("EDIT_INFO5_C1"),
	
	EDIT_SUBLISTA_INFO1_C2("EDIT_INFO1_C2"),
	EDIT_SUBLISTA_INFO2_C2("EDIT_INFO2_C2"),
	EDIT_SUBLISTA_INFO3_C2("EDIT_INFO3_C2"),
	EDIT_SUBLISTA_INFO4_C2("EDIT_INFO4_C2"),

	EDIT_SUBLISTA_INFO1_C3("EDIT_INFO1_C3"),
	EDIT_SUBLISTA_INFO2_C3("EDIT_INFO2_C3"),
	EDIT_SUBLISTA_INFO3_C3("EDIT_INFO3_C3"),
	EDIT_SUBLISTA_INFO4_C3("EDIT_INFO4_C3"),
		
	EDIT_TABLE_NAME("EDIT_TABLE_NAME"),
	EDIT_BUTTON_INFO("EDIT_BUTTON_INFO"),
	
	EDIT_COLUMN1_NAME("EDIT_NAME_COLUMN1"),
	EDIT_COLUMN2_NAME("EDIT_NAME_COLUMN2"),
	EDIT_COLUMN3_NAME("EDIT_NAME_COLUMN3"),
	EDIT_COLUMN4_NAME("EDIT_NAME_COLUMN4"),
	EDIT_COLUMN5_NAME("EDIT_NAME_COLUMN5"),
	EDIT_COLUMN6_NAME("EDIT_NAME_COLUMN6"),
	
    EDIT_INFO_FIRMA("EDIT_DIALOG_INFO1"),
    EDIT_INFO_TARA("EDIT_DIALOG_INFO2"),
    EDIT_INFO_AMBALARE("EDIT_DIALOG_INFO3"),
    EDIT_INFO_PRESCRIERE("EDIT_DIALOG_INFO4"),
    EDIT_INFO_PRET1("EDIT_DIALOG_INFO5"),
    EDIT_INFO_PRET2("EDIT_DIALOG_INFO6"),
    EDIT_INFO_PRET3A("EDIT_DIALOG_INFO7_1"),
    EDIT_INFO_PRET3B("EDIT_DIALOG_INFO7_2"),
    EDIT_INFO_PRET3C("EDIT_DIALOG_INFO7_3"),
    EDIT_INFO_PRET4("EDIT_DIALOG_INFO8"),
   
    
	;
  private static final String PROP_FILE="medicamenteMessages.properties";  
  private final String name;
  private String message;	 
	 private MedicamenteMessages(final String string){
		 this.name=string;
		 try{  
	         InputStream is = MedicamenteMessages.class.getResourceAsStream(PROP_FILE);  
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
