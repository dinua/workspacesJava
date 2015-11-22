package com.medweb.ui.pacient;

import com.medweb.ui.help.EnumOrdinal;

public enum PatientRhEnum implements EnumOrdinal{
	UNKNOWN(-1,""),
	RH_POZITIV(1,"pozitiv"),
	RH_NEGATIV(0,"negativ")
	;
	 private final int ordinal;
	 private final String nameMenu;
	 
	 private PatientRhEnum(final int ordinal){
		 this(ordinal,"");
	 }
  
	 private PatientRhEnum(final int ordinal,final String string){
		 this.ordinal=ordinal;
		 this.nameMenu=string;
	 }
	 public static PatientRhEnum fromInteger(final Integer appid){
			if(appid!=null){
				for(PatientRhEnum type : PatientRhEnum.values()){
					if(appid.intValue() == type.ordinal){
						return type;
					}
				}
			}
			return null;
		}
	 public static PatientRhEnum fromString(final String name){
			if(name!=null){
				for(PatientRhEnum type : PatientRhEnum.values()){
					if(name. equals( type.nameMenu)){
						return type;
					}
				}
			}
			return null;
		}
	 @Override
	public Object getOrdinal() {
		return Integer.valueOf(this.ordinal);
	}
	
	 public int getOrdinalValue(){
		return this.ordinal;
	}
	
	@Override
	public String toString() {
		return this.nameMenu;
	}
	
}
