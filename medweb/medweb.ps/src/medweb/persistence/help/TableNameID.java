package medweb.persistence.help;


public enum TableNameID implements EnumOrdinal{
    
	UNKNOWN(0),
	TABLE_USER_TYPE(1,"db_tip_user"),
	TABLE_USER(2,"db_user"),
	TABLE_PACIENT(3,"db_pacient"),
	TABLE_CASA_ASIGURARI(4,"db_casa_asigurari"),
	TABLE_CATEGORIE_ASIGURAT(5,"db_categorie_asigurat"),
	TABLE_MEDIC_PRIMAR(6,"db_medic_primar"),
	TABLE_CABINET_MEDICAL(7,"db_cabinet_medical"),
	TABLE_PACIENT_INFO(8,"db_info_pacient"),
	TABLE_INFO_MEDIC_PRIMAR(9,"db_info_medic_primar"),
	TABLE_ORAR(10,"db_orar"),
	TABLE_MEDICAMENT(11,"db_medicament"),
	TABLE_MEDICAMENT_INFO(12,"db_medicament_info"),
	TABLE_ADEVERINTA(13,"db_adeverinta"),
	TABLE_RETETA(14,"db_reteta"),
	TABLE_RETETA_LINIE(15,"db_reteta_linie"),
	
   JOIN_USER_USERTYPE(99,"db_user Inner join db_tip_user on (db_user.id_tip=db_tip_user.id_tip_user)"),
   JOIN_PATIENT_ASIG(100,"INNER JOIN db_categorie_asigurat " +
   		"ON (db_pacient.id_casa_asigurariP=db_categorie_asigurat.id_categorie_asigurat) " +
   		"INNER JOIN db_casa_asigurari ON (db_pacient.id_casa_asigurariP=" +
   		"db_casa_asigurari.id_casa_asigurari) "),
   JOIN_MEDIC(101,"INNER JOIN db_casa_asigurari ON (db_medic_primar.id_casa_asigurariMD=" +
   		                                           "db_casa_asigurari.id_casa_asigurari)"),
   JOIN_CABINET_MEDICAL(102,"INNER JOIN db_casa_asigurari ON (db_cabinet_medical.id_casa_asigurariCM=" +
   		"                                        db_casa_asigurari.id_casa_asigurari) "),
   	JOIN_MEDICAMENT_INFO(103,"INNER JOIN db_medicament on (db_medicament_info.id_medicamentI=db_medicament.id_medicament)"),
   	
   SELECT_JOIN_CONSULT(104,"SELECT * FROM db_consult INNER JOIN db_fisa on (db_consult.id_fisaConsult=db_fisa.id_fisa) INNER JOIN db_pacient on (db_fisa.id_pacientFisa=db_pacient.id_pacient) INNER JOIN db_medic_primar on (db_fisa.id_medicFisa=db_medic_primar.id_medic_primar) where db_fisa.id_medicFisa=%value1 order by(db_consult.data_consult) DESC LIMIT 1000"),		
   SELECT_JOIN_FISA(105,"SELECT * from db_fisa  INNER JOIN db_pacient on (db_fisa.id_pacientFisa=db_pacient.id_pacient) INNER JOIN db_medic_primar on (db_fisa.id_medicFisa=db_medic_primar.id_medic_primar) WHERE db_pacient.id_pacient=%value1 AND db_medic_primar.id_medic_primar=%value2"),		
   JOIN_RETETA_LINIE(106,"INNER JOIN db_medicament on (db_medicament.id_medicament=db_reteta_linie.id_medicamentL)"), 
   JOIN_TIP_USER(107,"INNER JOIN db_user on(db_tip_user.id_tip_user=db_user.id_tip)"),
   
   INSERT_PACIENT(200,"INSERT INTO db_pacient(numePacient,prenumePacient,id_categorie_asiguratP,id_casa_asigurariP,id_medic_primarP,asiguratP,activ) " +
    		"VALUES('%value1','%value2',%value3,%value4,%value5,%value6,%value7);"),		
   INSERT_PACIENT_INFO(201,"INSERT INTO db_info_pacient(id_pacient,cnp,data_nastere,loc_nastere," +
   		"sex,grupa_sanguina,stare_civila,rh,adresa,cod_postal,telefon,email,serie_buletin," +
   		"nr_buletin,nr_contract_CNAS)" +
   		" VALUES (%value1,'%value2','%value3','%value4','%value5','%value6','%value7',%value8," +
   		"'%value9','%wert1','%wert2','%wert3','%wert4','%wert5','%wert6');"),
   INSERT_CONSULT(202,"INSERT INTO db_consult(id_fisaConsult,data_consult,observatii) VALUES(%value1,'%value2','%value3');"),
   INSERT_ADEVERINTA(203,"INSERT INTO db_adeverinta(id_consultAdeverinta,ocupatie,suferind,recomandareF,motiv_eliberare,data_eliberare,concluzii,radiologie,serologie,recomandareV,apt) VALUES(%value1,'%value2','%value3','%value4','%value5','%value6','%value7','%value8','%value9','%wert1','%wert2')"),		
   INSERT_RETETA(204,"INSERT INTO db_reteta (id_consultatie_reteta,data_prescriere,unitate_sanitara,codFiscal_reteta) VALUES(%value1,'%value2','%value3','%value4'); "),
   INSERT_RETETA_LINIE(205,"INSERT INTO db_reteta_linie(id_retetaL,id_medicamentL,cantitate,mod_administrare) VALUES(%value1,%value2,'%value3','%value4')"),
   INSERT_USER(206,"INSERT INTO db_user(username,password,activ,id_tip) VALUES('%value1','%value2',%value3,%value4);"),
   INSERT_MEDIC_PRIMAR(207,"INSERT INTO db_medic_primar(id_medic_primar,numeMedic,prenumeMedic,id_cabinet_medicalMD,id_casa_asigurariMD) VALUES(%value1,'%value2','%value3',%value4,%value5);"),
   INSERT_MEDIC_PRIMAR_INFO(208,"INSERT INTO db_info_medic_primar(id_medic_primar,cnp,initiala,adresa,telefon,cod_parafa,nr_licenta,nr_contract_CNAS,id_medic_primar_rezident) VALUES(%value1,'%value2','%value3','%value4','%value5','%value6','%value7','%value8',%value9)"),
   INSERT_FISA(209,"INSERT INTO db_fisa(id_pacientFisa,id_medicFisa,data_emiterii) VALUES(%value1,%value2,'%value3');"),
   
   UPDATE_PACIENT(300,"UPDATE db_pacient SET numePacient='%value1', prenumePacient='%value2',id_categorie_asiguratP=%value3,id_casa_asigurariP=%value4,id_medic_primarP=%value5,asiguratP=%value6 where id_pacient=%value7   "),
   UPDATE_PACIENT_INFO(301,"UPDATE db_info_pacient SET cnp='%value1',data_nastere='%value2',loc_nastere='%value3',sex='%value4',grupa_sanguina='%value5',stare_civila='%value6',rh=%value7,adresa='%value8',cod_postal='%value9',telefon='%wert1',email='%wert2',serie_buletin='%wert3',nr_buletin='%wert4',nr_contract_CNAS='%wert5' where id_info_pacient=%wert6   "),
   UPDATE_MEDIC_PRIMAR(302,"UPDATE db_medic_primar SET numeMedic='%value1',prenumeMedic='%value2', id_cabinet_medicalMD=%value3, id_casa_asigurariMD=%value4 where id_medic_primar=%value5 "),
   UPDATE_MEDIC_PRIMAR_INFO(303,"UPDATE db_info_medic_primar SET cnp='%value1', initiala='%value2', adresa='%value3', telefon='%value4', cod_parafa='%value5',nr_licenta='%value6',nr_contract_CNAS='%value7' where id_info_medic_primar=%value8"),
   
   ID_MAX_PACIENT(400,"SELECT MAX(id_pacient) FROM db_pacient"),
   ID_MAX_CONSULT(401,"SELECT MAX(id_consult) FROM db_consult"),
   ID_MAX_RETETA(402,"SELECT MAX(id_reteta) FROM db_reteta"),
   ID_MAX_USER(403,"SELECT MAX(id_user) FROM db_user")
    ;
   	
	 
	 private final int ordinal;
	 private final String name;
	 
	 private TableNameID(final int ordinal){
		 this(ordinal,"Unknown");
	 }
  
	 private TableNameID(final int ordinal,final String string){
		 this.ordinal=ordinal;
		 this.name=string;
	 }
	 
	@Override
	public Object getOrdinal() {
		
		return Integer.valueOf(this.ordinal);
	}

	public int getOrdinalValue(){
		return this.ordinal;
	}
	
	public static TableNameID fromInteger(final Integer appid){
		if(appid!=null){
			for(TableNameID type : TableNameID.values()){
				if(appid.intValue() == type.ordinal){
					return type;
				}
			}
		}
		return null;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name;
	}
	
}
