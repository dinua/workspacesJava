package com.medweb.ui.table;

import com.medweb.ui.help.EnumOrdinal;

public enum CriteriaType  implements EnumOrdinal {

	CRITERIA_ANY(0,"--"),
   CRITERIA_IS(1,"IS"),
   CRITERIA_LIKE(2,"LIKE"),
   CRITERIA_NOT(3,"NOT")
      ;
 private final String name;
 private final int id;	 
	
	 private CriteriaType(final int id,final String string){
		 this.name=string;
		 this.id=id;
	 }

	 public String toString() {
			return this.name;
		}
		
   public static CriteriaType fromString(final String namee){
			if(namee!=null){
				for(CriteriaType type : CriteriaType.values()){
					if(namee. equals( type.toString())){
						return type;
					}
				}
			}
			return null;
		}

@Override
public Object getOrdinal() {
	
	return id;
}
}
