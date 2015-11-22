package com.medweb.ui.pacient;

import java.io.InputStream;
import java.util.Properties;

public enum PacientMessages {

	UNKNOWN(""),
	EDIT_INFO("Edit_Info"),
	EDIT_ERROR_NO_ELEM_SELECT("Error_No_Elem"),
	EDIT_DELETE_TITLE("Edit_Delete"),
	EDIT_DELETE_TEXT("Edit_Delete_Info"),
	
	EDIT_INFO_CNP("Edit_CNP"),
	EDIT_INFO_BIRTHDAY("Edit_Birthday"),
	EDIT_INFO_BDAY_PLACE("Edit_BDay_Place"),
	EDIT_INFO_SEX("Edit_Sex"),
	EDIT_INFO_GRUPA_SANGUINA("Edit_Grupa_Sanguina"),
	EDIT_INFO_STARE_CIVILA("Edit_Stare_Civila"),
	EDIT_INFO_RH("Edit_RH"),
	EDIT_INFO_ADRESA("Edit_Adresa"),
	EDIT_INFO_COD_POSTAL("Edit_Cod_Postal"),
	EDIT_INFO_TELEFON("Edit_Telefon"),
	EDIT_INFO_EMAIL("Edit_Email"),
	EDIT_INFO_SERIE_BULETIN("Edit_Serie_Buletin"),
	EDIT_INFO_NR_BULETIN("Edit_Nr_Buletin"),
	EDIT_INFO_NR_CONTRACT_CNAS("Edit_Nr_Contract_CNAS"),
	
	EDIT_JUDET("Edit_Judet"),
	EDIT_LOCALITATE("Edit_Localitate"),
	EDIT_STRADA("Edit_Strada"),
	EDIT_NUMAR("Edit_Numar"),
	EDIT_SAVE("Edit_Save"),
	EDIT_NUME("Edit_Nume"),
	EDIT_PRENUME("Edit_Prenume"),
	EDIT_CASA_ASIGURARI("Edit_Asigurari"),
	EDIT_CATEGORIE_ASIGURARE("Edit_Categorie"),
	EDIT_ASIGURAT("Edit_Asigurat"),
	
	EDIT_COLUMN_NUME("EDIT_COLUMN_NUME"),
	EDIT_COLUMN_PRENUME("EDIT_COLUMN_PRENUME"),
	EDIT_COLUMN_DATE("EDIT_COLUMN_DATE"),
	EDIT_COLUMN_OBS("EDIT_COLUMN_OBS"),
	
	EDIT_BUTTON_NEW_VISIT("Edit_Button_Visit"),
	EDIT_BUTTON_DELETE("Edit_Button_Delete"),
	EDIT_BUTTON_INFO("Edit_Button_Info"),
	
	EDIT_RETETA("Edit_Reteta"),
	EDIT_ADEVERINTA("Edit_Adeverinta"),

	;
  private static final String PROP_FILE="pacientMessages.properties";  
  private final String name;
  private String message;	 
	 private PacientMessages(final String string){
		 this.name=string;
		 try{  
	         InputStream is = PacientMessages.class.getResourceAsStream(PROP_FILE);  
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
