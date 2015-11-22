package com.medweb.ui.medic;

import com.medweb.ui.help.EnumOrdinal;

public enum HourEnum implements EnumOrdinal{
	    UNKNOWN(0,""),
		HOUR_08(1,"08:00"),
		HOUR_10(2,"10:00"),
		HOUR_12(3,"12:00"),
		HOUR_14(4,"14:00"),
		HOUR_16(5,"16:00"),
		HOUR_18(6,"18:00"),
		HOUR_20(7,"20:00"),
		Close(8,"Inchis"),
		
	;
   private final int ordinal;
   private final String nameMenu;
		 
   private HourEnum(final int ordinal){
			 this(ordinal,"Unknown");
	 }
	  
   private HourEnum(final int ordinal,final String string){
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
	public static HourEnum fromInteger(final Integer appid){
		if(appid!=null){
			for(HourEnum type : HourEnum.values()){
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
	public static HourEnum fromString(final String name){
		if(name!=null){
			for(HourEnum type : HourEnum.values()){
				if(name. equals( type.nameMenu)){
					return type;
				}
			}
		}
		return UNKNOWN;
	}
}
