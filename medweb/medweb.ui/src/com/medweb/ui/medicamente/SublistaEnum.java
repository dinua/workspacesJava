package com.medweb.ui.medicamente;

import com.medweb.ui.help.EnumOrdinal;

public enum SublistaEnum implements EnumOrdinal{
	
	UNKNOWN(0),
	SUBLISTA_A(1,"SublistaA"),
	SUBLISTA_B(2,"SublistaB"),
	SUBLISTA_C1(3,"SublistaC1"),
	SUBLISTA_C2(4,"SublistaC2"),
	SUBLISTA_C3(5,"SublistaC3"),
	
	;

	 private final int ordinal;
	 private final String nameMenu;
	 
	 private SublistaEnum(final int ordinal){
		 this(ordinal,"Unknown");
	 }
  
	 private SublistaEnum(final int ordinal,final String string){
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
	
	public static SublistaEnum fromInteger(final Integer appid){
		if(appid!=null){
			for(SublistaEnum type : SublistaEnum.values()){
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
	
	public static SublistaEnum fromString(final String name){
		if(name!=null){
			for(SublistaEnum type : SublistaEnum.values()){
				if(name. equals( type.nameMenu)){
					return type;
				}
			}
		}
		return null;
	}

}
