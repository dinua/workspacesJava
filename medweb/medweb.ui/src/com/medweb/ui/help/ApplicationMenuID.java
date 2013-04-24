package com.medweb.ui.help;


public enum ApplicationMenuID implements EnumOrdinal{
    
	 UNKNOWN(0),
	FOLDER_NAME1(1,"Medic Menu"),
	FOLDER_NAME2(2,"Patient Menu"),
	FOLDER_NAME3(3,"Adeverinte/Scutiri Medicale"),
	FOLDER_NAME4(4,"Medicamente Menu"),
	FOLDER_NAME5(5,"Mod administrare"),
	//FOLDER_NAME5(5,"NAME5"),
	//FOLDER_NAME6(6,"NAME6"),
	
	FILE_PATIENT1(7,"New Patient"),
	FILE_PATIENT2(8,"Patient"),
	FILE_PATIENT3(9,"Visit History"),
	FILE_PACIENT4(10,"Pacienti inactivi"),
	
	FILE_MEDIC1(20,"Orar"),
	FILE_MEDIC2(21,"Date personale"),
	FILE_MEDIC3(22,"Cabinet"),
	FILE_MEDIC4(23,"Casa Asigurari"),
	
	FILE_MEDICAL1(30,"Lista scutiri"),
	FILE_MEDICAL2(31,"Lista adeverinte"),
	FILE_MEDICAL3(32,"xxxx"),
	
	FILE_MEDICAMENTE1(40,"sublistaA"),
	FILE_MEDICAMENTE2(41,"sublistaB"),
	FILE_MEDICAMENTE3(42,"sublistaC1"),
	FILE_MEDICAMENTE4(43,"sublistaC2"),
	FILE_MEDICAMENTE5(44,"sublistaC3"),
	
	FILE_ADMINISTRARE1(50,"Creare user"),
	FILE_ADMINISTRARE2(51,"Lista useri activi"),
	FILE_ADMINISTRARE3(52,"Lista useri inactivi"),
	;
	
	 
	 private final int ordinal;
	 private final String nameMenu;
	 
	 private ApplicationMenuID(final int ordinal){
		 this(ordinal,"Unknown");
	 }
  
	 private ApplicationMenuID(final int ordinal,final String string){
		 this.ordinal=ordinal;
		 this.nameMenu=string;
	 }
	 
	@Override
	public Object getOrdinal() {
		
		return Integer.valueOf(this.ordinal);
	}

	public int getOrdinalValue(){
		return this.ordinal;
	}
	
	public static ApplicationMenuID fromInteger(final Integer appid){
		if(appid!=null){
			for(ApplicationMenuID type : ApplicationMenuID.values()){
				if(appid.intValue() == type.ordinal){
					return type;
				}
			}
		}
		return null;
	}
	@Override
	public String toString() {
		return this.nameMenu;
	}
	
	public static ApplicationMenuID fromString(final String name){
		if(name!=null){
			for(ApplicationMenuID type : ApplicationMenuID.values()){
				if(name. equals( type.nameMenu)){
					return type;
				}
			}
		}
		return null;
	}
}
