package com.medweb.ui.pacient;

import com.medweb.ui.help.EnumOrdinal;

public enum PatientSexEnum implements EnumOrdinal{
	UNKNOWN(0),
	SEX_MALE(1,"M"),
	SEX_FEMELE(2,"F")
	;
	 private final int ordinal;
	 private final String nameMenu;
	 
	 private PatientSexEnum(final int ordinal){
		 this(ordinal,"Unknown");
	 }
  
	 private PatientSexEnum(final int ordinal,final String string){
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
	
	@Override
	public String toString() {
		return this.nameMenu;
	}
	
}
