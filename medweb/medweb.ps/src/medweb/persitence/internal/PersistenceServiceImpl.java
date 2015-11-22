package medweb.persitence.internal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import medweb.persistence.help.Conversii;
import medweb.persistence.help.TableNameID;
import medweb.persitence.PersistenceService;
import medweb.psconf.connection.ConnectionI;
import medweb.psconf.daos.Adeverinta;
import medweb.psconf.daos.CabinetMedical;
import medweb.psconf.daos.CasaAsigurari;
import medweb.psconf.daos.CategorieAsigurat;
import medweb.psconf.daos.Consult;
import medweb.psconf.daos.Fisa;
import medweb.psconf.daos.MedicPrimar;
import medweb.psconf.daos.MedicPrimarInfo;
import medweb.psconf.daos.Medicament;
import medweb.psconf.daos.MedicamentInfo;
import medweb.psconf.daos.Orar;
import medweb.psconf.daos.Pacient;
import medweb.psconf.daos.PacientInfo;
import medweb.psconf.daos.Reteta;
import medweb.psconf.daos.RetetaLinie;
import medweb.psconf.daos.User;
import medweb.psconf.daos.UserType;


public class PersistenceServiceImpl implements PersistenceService {
	private final ConnectionI connection;
	private ResultSet resultSet;
	public PersistenceServiceImpl(ConnectionI conn){
		super();
		this.connection=conn;
	}
	
	@Override
	public User isAUser(String username, String password) throws SQLException {
		User user=null;
		String restiction=" db_user.username='"+username+"' and db_user.password='"+password+"'";
		resultSet=connection.selectAll(TableNameID.JOIN_USER_USERTYPE.toString(), restiction);
		
			while(resultSet.next()){
				UserType userType=Conversii.getUserTypeFromResultSet(resultSet);
			    user=Conversii.getUserFromResultSet(resultSet);
				user.setUserType(userType);
			}
		
		return user;
	}
	@Override
	public List<User> getAllActivUsers() throws SQLException {
		List<User> list=new ArrayList<User>();
		resultSet=connection.selectAll(TableNameID.JOIN_USER_USERTYPE.toString()," activ=1 AND db_tip_user.id_tip_user<>1");
		while(resultSet.next()){
			UserType userType=Conversii.getUserTypeFromResultSet(resultSet);
		    User user=Conversii.getUserFromResultSet(resultSet);
			user.setUserType(userType);
			list.add(user);
		}
		return list;
	}

	@Override
	public List<User> getAllInactivUsers() throws SQLException {
		List<User> list=new ArrayList<User>();
		resultSet=connection.selectAll(TableNameID.JOIN_USER_USERTYPE.toString()," activ=0 AND db_tip_user.id_tip_user<>1");
		while(resultSet.next()){
			UserType userType=Conversii.getUserTypeFromResultSet(resultSet);
		    User user=Conversii.getUserFromResultSet(resultSet);
			user.setUserType(userType);
			list.add(user);
		}
		return list;
	}
	@Override
	public void setUserActiv(int idUser) throws SQLException {
		String values="activ=1";
		String restiction="id_user="+idUser;
		connection.update(TableNameID.TABLE_USER.toString(),values,restiction);
		
	}

	@Override
	public void setUserInactiv(int idUser) throws SQLException {
		String values="activ=0";
		String restiction="id_user="+idUser;
		connection.update(TableNameID.TABLE_USER.toString(),values,restiction);
		
	}
	@Override
	public List<UserType> getAllUserTypes() throws SQLException {
		List<UserType> list=new ArrayList<UserType>();
		resultSet=connection.selectAll(TableNameID.TABLE_USER_TYPE.toString(), "id_tip_user<>1");
		while(resultSet.next()){
			UserType u=Conversii.getUserTypeFromResultSet(resultSet);
			list.add(u);
		}
		
		return list;
	}
	@Override
	public UserType getUserTypeByName(String name) throws SQLException {
		UserType type=null;
		resultSet=connection.selectAll(TableNameID.TABLE_USER_TYPE.toString(), "nume_tip_user='"+name+"'");
		while(resultSet.next()){
			type=Conversii.getUserTypeFromResultSet(resultSet);
		}
		return type;
	}
	@Override
	public UserType getUserTypeForUser(int idUser) throws SQLException {
		UserType type=null;
		
		resultSet=connection.selectAll(TableNameID.TABLE_USER_TYPE+" "+TableNameID.JOIN_TIP_USER, "db_user.id_user="+idUser);
		while(resultSet.next()){
			type=Conversii.getUserTypeFromResultSet(resultSet);
		}
		return type;
	}

	@Override
	public int saveUser(User user) throws SQLException {
		String query=TableNameID.INSERT_USER.toString();
		query=query.replace("%value1", user.getUsername());
		query=query.replace("%value2", user.getPassword());
		query=query.replace("%value3", ""+user.isActiv());
		query=query.replace("%value4", ""+user.getUserType().getIdUserType());
		query=query.replaceAll("''", "null");
		 connection.insert(query);
			resultSet=connection.select(TableNameID.ID_MAX_USER.toString());
			int id=0;
			
				while(resultSet.next()){
					id=resultSet.getInt(1);
				}
		
		return id;
	}
	@Override
	public Pacient getPatientByID(int id) throws SQLException {
		//resultSet=connection.selectAll(TableNameID.TABLE_PACIENT.toString());
		//System.out.println(TableNameID.TABLE_PACIENT +" "+TableNameID.JOIN_PATIENT_ASIG);
		Pacient pacient=null;
		resultSet=connection.selectAll(TableNameID.TABLE_PACIENT+" "+TableNameID.JOIN_PATIENT_ASIG, 
				                              "db_pacient.id_pacient="+id);
			while(resultSet.next()){
				pacient=Conversii.getPacientFromResultSet(resultSet);
				MedicPrimar medic=this.getMedicPrimarByID(pacient.getId_medic());
				pacient.setMedicPrimar(medic);
			}
		
		return pacient;
	}
	
	@Override
	public PacientInfo getInfoPacient(Pacient pacient) throws SQLException {
		PacientInfo pacientInfo=null;
		resultSet=connection.selectAll(TableNameID.TABLE_PACIENT_INFO.toString(), "db_info_pacient.id_pacient="+pacient.getIdPacient());
		
			while(resultSet.next()){
				pacientInfo=Conversii.getPacientInfoFromResultSet(resultSet);
				pacientInfo.setPacient(pacient);
			}
		
		return pacientInfo;
	}
	
	@Override
	public List<Pacient> getAllPatientsLight()  throws SQLException {
		List<Pacient> list=new ArrayList<Pacient>();
		resultSet=connection.selectAll(TableNameID.TABLE_PACIENT.toString());
		
			while(resultSet.next()){
				Pacient patient=Conversii.getLightPatientFromResultSet(resultSet);
				list.add(patient);
			}
		
		
		return list;
	}
	
	@Override
	public List<Pacient> getAllActivPatientsForMedic(int idMedic) throws SQLException {
		List<Pacient> list=new ArrayList<Pacient>();
		resultSet=connection.selectAll(TableNameID.TABLE_PACIENT.toString(),"activ=1 and id_medic_primarP="+idMedic);
		while(resultSet.next()){
			Pacient patient=Conversii.getLightPatientFromResultSet(resultSet);
			list.add(patient);
		}
		return list;
	}
	@Override
	public List<Pacient> getAllInactivPatientsForMedic(int idMedic)  throws SQLException{
		List<Pacient> list=new ArrayList<Pacient>();
		resultSet=connection.selectAll(TableNameID.TABLE_PACIENT.toString(),"activ=0 and id_medic_primarP="+idMedic);
		while(resultSet.next()){
			Pacient patient=Conversii.getLightPatientFromResultSet(resultSet);
			list.add(patient);
		}
		return list;
	}
	
	@Override
	public int savePatient(Pacient pacient)  throws SQLException {
		String query=TableNameID.INSERT_PACIENT.toString();
		query=query.replace("%value1", pacient.getNume());
		query=query.replace("%value2", pacient.getPrenume());
		query=query.replace("%value3", ""+pacient.getCasaAsigurari().getIdCasaAsigurari());
		query=query.replace("%value4", ""+pacient.getCasaAsigurari().getIdCasaAsigurari());
		query=query.replace("%value5", ""+pacient.getMedicPrimar().getIdMedicPrimar());
		query=query.replace("%value6", ""+pacient.isAsigurat());
		query=query.replace("%value7", "1");
	
	   connection.insert(query);
		resultSet=connection.select(TableNameID.ID_MAX_PACIENT.toString());
		int id=0;
		
			while(resultSet.next()){
				id=resultSet.getInt(1);
			}
		
			return id;
	}
	@Override
	public int updatePatient(Pacient pacient)  throws SQLException{
		String query=TableNameID.UPDATE_PACIENT.toString();
		query=query.replace("%value1", pacient.getNume());
		query=query.replace("%value2", pacient.getPrenume());
		query=query.replace("%value3", ""+pacient.getCasaAsigurari().getIdCasaAsigurari());
		query=query.replace("%value4", ""+pacient.getCasaAsigurari().getIdCasaAsigurari());
		query=query.replace("%value5", ""+pacient.getMedicPrimar().getIdMedicPrimar());
		query=query.replace("%value6", ""+pacient.isAsigurat());
		query=query.replace("%value7", ""+pacient.getIdPacient());
		//System.err.println(query);
		connection.update(query);
		return 0;
	}
	
	@Override
	public int savePatientInfo(PacientInfo info)  throws SQLException{
		String query=TableNameID.INSERT_PACIENT_INFO.toString();
		query=query.replace("%value1", ""+info.getPacient().getIdPacient());
		query=query.replace("%value2", info.getCnp());
		query=query.replace("%value3", info.getDataNastere());
		query=query.replace("%value4", info.getLocNastere());
		query=query.replace("%value5",info.getSex());
		query=query.replace("%value6", info.getGrupaSanguina());
		query=query.replace("%value7", info.getStareCivila());
		if(info.getRh()==-1){
			query=query.replace("%value8", "null");
		}
		else{
			query=query.replace("%value8", ""+info.getRh());
		}
		
		query=query.replace("%value9", info.getAdresa());
		query=query.replace("%wert1", info.getCodPostal());
		query=query.replace("%wert2", info.getTelefon());
		query=query.replace("%wert3", info.getEmail());
		query=query.replace("%wert4", info.getSerieBuletin());
		query=query.replace("%wert5", info.getNrBuletin());
		query=query.replace("%wert6", info.getNrContractCNAS());
		query=query.replaceAll("''", "null");
		connection.insert(query);
		return 0;
	}
	
	@Override
	public void deletePatient(Pacient pacient)  throws SQLException{
		connection.delete(TableNameID.TABLE_PACIENT.toString(), "id_pacient="+pacient.getIdPacient());
		
	}
	@Override
	public void deletePatientInfo(Pacient pacient)  throws SQLException{
		connection.delete(TableNameID.TABLE_PACIENT_INFO.toString(), "id_pacient="+pacient.getIdPacient());
		
	}
	@Override
	public List<CasaAsigurari> getAllCasaAsigurari() throws SQLException {
		List<CasaAsigurari> list=new ArrayList<CasaAsigurari>();
		resultSet=connection.selectAll(TableNameID.TABLE_CASA_ASIGURARI.toString());
			while(resultSet.next()){
				CasaAsigurari casa=Conversii.getCasaAsigurariFromResultSet(resultSet);
				list.add(casa);
			}
		
		return list;
	}
	
	@Override
	public void setPatientActiv(int IdPatient) throws SQLException {
		
		String values="activ=1";
		String restiction="id_pacient="+IdPatient;
		connection.update(TableNameID.TABLE_PACIENT.toString(),values,restiction);
		
	}

	@Override
	public void setPatientInactiv(int IdPatient) throws SQLException {
		String values="activ=0";
		String restiction="id_pacient="+IdPatient;
		connection.update(TableNameID.TABLE_PACIENT.toString(),values,restiction);
		
	}
	
	@Override
	public List<CategorieAsigurat> getAllCategorieAsigurat() throws SQLException {
		List<CategorieAsigurat> list=new ArrayList<CategorieAsigurat>();
		resultSet=connection.selectAll(TableNameID.TABLE_CATEGORIE_ASIGURAT.toString());
		
			while(resultSet.next()){
				CategorieAsigurat categorie=Conversii.getCategorieAsiguratFromResultSet(resultSet);
				list.add(categorie);
			}
		
		return list;
	}
	@Override
	public MedicPrimar getMedicPrimarByID(int id) throws SQLException {
		MedicPrimar medic=null;
		resultSet=connection.selectAll(TableNameID.TABLE_MEDIC_PRIMAR+" "+TableNameID.JOIN_MEDIC
				                           ,"db_medic_primar.id_medic_primar="+id);
			while(resultSet.next()){
				medic=Conversii.getMedicPrimarFromResultSet(resultSet);
				CabinetMedical cabinetMedical=this.getCabinetMedicalByID(medic.getId_cabinet());
				medic.setCabinetMedical(cabinetMedical);
			}
		
		return medic;
	}
	@Override
	public CabinetMedical getCabinetMedicalByID(int id) throws SQLException {
		CabinetMedical cabinet=null;
		resultSet=connection.selectAll(TableNameID.TABLE_CABINET_MEDICAL+" "+TableNameID.JOIN_CABINET_MEDICAL
                ,"db_cabinet_medical.id_cabinet_medical="+id);
            
                  while(resultSet.next()){
                       cabinet=Conversii.getCabinetMedicalFromResultSet(resultSet);
                      }
             
		return cabinet;
	}

	
	
	@Override
	public CategorieAsigurat getCategorieAsiguratByName(String name) throws SQLException {
		CategorieAsigurat categorie=null;
		resultSet=connection.selectAll(TableNameID.TABLE_CATEGORIE_ASIGURAT.toString(), 
				"db_categorie_asigurat.nume_categorie_asigurat='"+name+"'");
		
		
			while(resultSet.next()){
				 categorie=Conversii.getCategorieAsiguratFromResultSet(resultSet);
				
			}
		
		return categorie;
	}
	@Override
	public CasaAsigurari getCasaAsigurariByName(String name) throws SQLException {
		//light info
		CasaAsigurari casa=null;
		resultSet=connection.selectAll(TableNameID.TABLE_CASA_ASIGURARI.toString(), 
				"nume_casa_asig='"+name+"'");
		
			while(resultSet.next()){
				casa=Conversii.getCasaAsigurariFromResultSet(resultSet);
				
			}
		
		return casa;
	}
	
	
	
	@Override
	public int updatePatientInfo(PacientInfo info) {
		String query=TableNameID.UPDATE_PACIENT_INFO.toString();
		query=query.replace("%value1", info.getCnp());
		query=query.replace("%value2", info.getDataNastere());
		query=query.replace("%value3", info.getLocNastere());
		query=query.replace("%value4", info.getSex());
		query=query.replace("%value5", info.getGrupaSanguina());
		query=query.replace("%value6", info.getStareCivila());
		if(info.getRh()==-1){
			query=query.replace("%value7", "null");
		}
		else{
			query=query.replace("%value7", ""+info.getRh());
		}
		query=query.replace("%value8", info.getAdresa());
		query=query.replace("%value9", info.getCodPostal());
		query=query.replace("%wert1", info.getTelefon());
		query=query.replace("%wert2", info.getEmail());
		query=query.replace("%wert3", info.getSerieBuletin());
		query=query.replace("%wert4", info.getNrBuletin());
		query=query.replace("%wert5", info.getNrContractCNAS());
		query=query.replace("%wert6", ""+info.getIdInfoPacient());
		query=query.replaceAll("''", "null");
		
		//System.err.println(query);
		connection.update(query);
		return 0;
	}
	
	@Override
	public MedicPrimarInfo getInfoMedicPrimar(MedicPrimar medicPrimar) throws SQLException {
		MedicPrimarInfo info=null;
		resultSet=connection.selectAll(TableNameID.TABLE_INFO_MEDIC_PRIMAR.toString(),"id_medic_primar="+medicPrimar.getIdMedicPrimar());
		
			while(resultSet.next()){
				info=Conversii.getInfoMedicPrimar(resultSet);
				info.setMedicPrimar(medicPrimar);
			}
		
		
		return info;
	}
	@Override
	public Orar getOrarMedic(MedicPrimar medicPrimar) throws SQLException {
		Orar orar=null;
		resultSet=connection.selectAll(TableNameID.TABLE_ORAR.toString()," id_medic_primar_orar="+medicPrimar.getIdMedicPrimar());
		
			while(resultSet.next()){
				orar=Conversii.getOrarFromResultSet(resultSet);
				orar.setMedicPrimar(medicPrimar);
			}
		
		return orar;
	}
	@Override
	public int updateMedicPrimar(MedicPrimar medicPrimar) {
		
		String query=TableNameID.UPDATE_MEDIC_PRIMAR.toString();
		query=query.replace("%value1", medicPrimar.getNume());
		query=query.replace("%value2", medicPrimar.getPrenume());
		query=query.replace("%value3", ""+medicPrimar.getCabinetMedical().getIdCabinet());
		query=query.replace("%value4", ""+medicPrimar.getCasaAsigurari().getIdCasaAsigurari());
		query=query.replace("%value5", ""+medicPrimar.getIdMedicPrimar());
		//System.out.println(query);
		connection.update(query);
		return 0;
	}
	@Override
	public int updateMedicPrimarInfo(MedicPrimarInfo medicPrimarInfo) {
		
		String query=TableNameID.UPDATE_MEDIC_PRIMAR_INFO.toString();
		query=query.replace("%value1", medicPrimarInfo.getCNP());
		query=query.replace("%value2", medicPrimarInfo.getInitiala());
		query=query.replace("%value3", medicPrimarInfo.getAdresa());
		query=query.replace("%value4", medicPrimarInfo.getTelefon());
		query=query.replace("%value5", medicPrimarInfo.getCodParafa());
		query=query.replace("%value6", medicPrimarInfo.getNrLicenta());
		query=query.replace("%value7", medicPrimarInfo.getNrContractCNAS());
		query=query.replace("%value8", ""+medicPrimarInfo.getIdInfoMedicPrimar());
		query=query.replaceAll("''", "null");
		//System.err.println(query);
		connection.update(query);
		return 0;
	}
	@Override
	public CabinetMedical getCabinetMedicalByName(String name) throws SQLException {
		
		CabinetMedical cabinet=null;
		resultSet=connection.selectAll(TableNameID.TABLE_CABINET_MEDICAL+" "+TableNameID.JOIN_CABINET_MEDICAL.toString()," numeCabinet='"+name+"'");
		
			while(resultSet.next()){
				cabinet=Conversii.getCabinetMedicalFromResultSet(resultSet);
			}
		
		return cabinet;
	}
	@Override
	public List<Consult> getAllConsultatiiForMedic(MedicPrimar medicPrimar) throws SQLException {
		List<Consult> list=new ArrayList<>();
		String query=TableNameID.SELECT_JOIN_CONSULT.toString();
		query=query.replace("%value1", ""+medicPrimar.getIdMedicPrimar());
		resultSet=connection.select(query);
		while(resultSet.next()){
			Consult consult=Conversii.getConsultFromResultSet(resultSet);
			list.add(consult);
		}
		return list;
	}
	@Override
	public Fisa getFisaPacinet(int idPacient, int idMedicPrimar)
			throws SQLException {
		Fisa fisa = null;
		String query=TableNameID.SELECT_JOIN_FISA.toString();
		query=query.replace("%value1", ""+idPacient);
		query=query.replace("%value2", ""+idMedicPrimar);
		resultSet=connection.select(query);
		while(resultSet.next()){
			fisa=Conversii.getFisaFromResultSet(resultSet);
		}
		return fisa;
	}

	@Override
	public MedicamentInfo getMedicamentInfoById(int idMedicamnet)
			throws SQLException {
		MedicamentInfo info=null;
		resultSet=connection.selectAll(TableNameID.TABLE_MEDICAMENT_INFO+" "+TableNameID.JOIN_MEDICAMENT_INFO ,
				 "db_medicament.id_medicament="+idMedicamnet);
		while(resultSet.next()){
			info=Conversii.getInfoMedicamentFromResultSet(resultSet);
		}
		return info;
	}

	@Override
	public List<Medicament> getSublistaMedicamente(int idSublista)
			throws SQLException {
		List<Medicament> list=new ArrayList<Medicament>();
		resultSet=connection.selectAll(TableNameID.TABLE_MEDICAMENT.toString(), "nr_sublista="+idSublista);
		while(resultSet.next()){
			Medicament medi=Conversii.getMedicamentFromResultSet(resultSet);
			list.add(medi);
		}
		return list;
	}

	@Override
	public List<Medicament> getAllMedicamente() throws SQLException {
		List<Medicament> list=new ArrayList<Medicament>();
		resultSet=connection.selectAll(TableNameID.TABLE_MEDICAMENT.toString());
		while(resultSet.next()){
			Medicament medi=Conversii.getMedicamentFromResultSet(resultSet);
			list.add(medi);
		}
		return list;
	}

	@Override
	public Medicament getMedicamentByProperties(String codAtc,
			String denumireC, int nrSublista) throws SQLException {
		Medicament medicament = null;
		String restiction="db_medicament.cod_atc='"+codAtc+"' AND db_medicament.denumire_comerciala='"+denumireC
				  +"' AND db_medicament.nr_sublista="+nrSublista;
		resultSet=connection.selectAll(TableNameID.TABLE_MEDICAMENT.toString(),restiction);
		while(resultSet.next()){
			medicament=Conversii.getMedicamentFromResultSet(resultSet);
		}
		return medicament;
	}
	@Override
	public Medicament getMedicamentByProperties(String codAtc,
			String denumireC) throws SQLException {
		Medicament medicament = null;
		String restiction="db_medicament.cod_atc='"+codAtc+"' AND db_medicament.denumire_comerciala='"+denumireC+"'"; 
		resultSet=connection.selectAll(TableNameID.TABLE_MEDICAMENT.toString(),restiction);
		while(resultSet.next()){
			medicament=Conversii.getMedicamentFromResultSet(resultSet);
		}
		return medicament;
	}
	@Override
	public int saveConsult(Consult consult) throws SQLException {
		
		String query=TableNameID.INSERT_CONSULT.toString();
		query=query.replace("%value1",""+ consult.getFisa().getIdFisa());
		query=query.replace("%value2", consult.getDataConsult());
		query=query.replace("%value3", consult.getObservatii());
		query=query.replaceAll("''", "null");
		
		connection.insert(query);
		resultSet=connection.select(TableNameID.ID_MAX_CONSULT.toString());
		int id=0;
		
		while(resultSet.next()){
			id=resultSet.getInt(1);
		}
	
		return id;
	}

	@Override
	public int saveAdeverinta(Adeverinta adeverinta) throws SQLException {
		String query=TableNameID.INSERT_ADEVERINTA.toString();
		query=query.replace("%value1", ""+adeverinta.getConsult().getIdConsult());
		query=query.replace("%value2", adeverinta.getOcupatie());
		query=query.replace("%value3", adeverinta.getSuferind());
		query=query.replace("%value4", adeverinta.getRecomandare1());
		query=query.replace("%value5", adeverinta.getMotivEliberare());
		query=query.replace("%value6", adeverinta.getDataEliberarii());
		query=query.replace("%value7", adeverinta.getConcluzii());
		query=query.replace("%value8", adeverinta.getRadiologie());
		query=query.replace("%value9", adeverinta.getSerologie());
		query=query.replace("%wert1", adeverinta.getRecomandare2());
		query=query.replace("%wert2", adeverinta.getApt());
		query=query.replaceAll("''", "null");
		
		connection.insert(query);
		return 0;
	}

	@Override
	public int saveReteta(Reteta reteta) throws SQLException {
		String query=TableNameID.INSERT_RETETA.toString();
		query=query.replace("%value1", ""+reteta.getConsult().getIdConsult());
		query=query.replace("%value2", reteta.getDataPrescriere());
		query=query.replace("%value3", reteta.getUnitateSanitara());
		query=query.replace("%value4", reteta.getCodFiscalReteta());
		query=query.replaceAll("''", "null");
				
		 connection.insert(query);
			resultSet=connection.select(TableNameID.ID_MAX_RETETA.toString());
			int id=0;
			
				while(resultSet.next()){
					id=resultSet.getInt(1);
				}
		
		return id;
	}

	@Override
	public int saveRetetaLinie(RetetaLinie retetaLinie) throws SQLException {
		String query=TableNameID.INSERT_RETETA_LINIE.toString();
		query=query.replace("%value1", ""+retetaLinie.getIdReteta() );
		query=query.replace("%value2",""+retetaLinie.getMedicament().getIdMedicament());
		query=query.replace("%value3", retetaLinie.getCantitate());
		query=query.replace("%value4", retetaLinie.getModAdministrare());
		query=query.replaceAll("''", "null");
		
		connection.insert(query);
		return 0;
	}

	@Override
	public Adeverinta getAdeverintaByConsultatie(Consult consult)
			throws SQLException {
		
		Adeverinta adeverinta=null;
		resultSet=connection.selectAll(TableNameID.TABLE_ADEVERINTA.toString(), "id_consultAdeverinta="+consult.getIdConsult());
		while(resultSet.next()){
			adeverinta=Conversii.getAdeverintaFromResultSet(resultSet);
			adeverinta.setConsult(consult);
		}
		
		return adeverinta;
	}

	@Override
	public Reteta getRetetaByConsultatie(Consult consult) throws SQLException {
		Reteta reteta=null;
		resultSet=connection.selectAll(TableNameID.TABLE_RETETA.toString(), "id_consultatie_reteta="+consult.getIdConsult());
		while(resultSet.next()){
			reteta=Conversii.getRetetaFromResultSet(resultSet);
			reteta.setConsult(consult);
		}
		return reteta;
	}

	@Override
	public List<RetetaLinie> getListMedicamenteReteta(int idReteta)
			throws SQLException {
		List<RetetaLinie> list=new ArrayList<RetetaLinie>();
		resultSet=connection.selectAll(TableNameID.TABLE_RETETA_LINIE.toString()+" "+TableNameID.JOIN_RETETA_LINIE.toString(),
				"db_reteta_linie.id_retetaL="+idReteta);
		while(resultSet.next()){
			RetetaLinie linie=Conversii.getRetetaLinieFromResultSet(resultSet);
			list.add(linie);
		}
		return list;
	}

	@Override
	public int saveMedicPrimar(MedicPrimar medicPrimar) throws SQLException {
		String query=TableNameID.INSERT_MEDIC_PRIMAR.toString();
		query=query.replace("%value1", ""+medicPrimar.getIdMedicPrimar());
		query=query.replace("%value2",medicPrimar.getNume());
		query=query.replace("%value3", medicPrimar.getPrenume());
		query=query.replace("%value4", ""+medicPrimar.getCabinetMedical().getIdCabinet());
		query=query.replace("%value5", ""+medicPrimar.getCasaAsigurari().getIdCasaAsigurari());
		query=query.replaceAll("''", "null");
		
		connection.insert(query);
		return 0;
	}

	@Override
	public int saveMedicPrimarInfo(MedicPrimarInfo info) throws SQLException {
		String query=TableNameID.INSERT_MEDIC_PRIMAR_INFO.toString();
		query=query.replace("%value1", ""+info.getMedicPrimar().getIdMedicPrimar());
		query=query.replace("%value2",info.getCNP());
		query=query.replace("%value3", info.getInitiala());
		query=query.replace("%value4", info.getAdresa());
		query=query.replace("%value5", info.getTelefon());
		query=query.replace("%value6", info.getCodParafa());
		query=query.replace("%value7", info.getNrLicenta());
		query=query.replace("%value8", info.getNrContractCNAS());
		query=query.replace("%value9", ""+info.getIdMedicRezident());
		query=query.replaceAll("''", "null");
		
		connection.insert(query);
		return 0;
	}

	@Override
	public int saveFisa(Fisa fisa) throws SQLException {
		String query=TableNameID.INSERT_FISA.toString();
		//query=query.replace("%value1", ""+fisa.getMedic().getIdMedicPrimar());
		query=query.replace("%value1",""+fisa.getPacient().getIdPacient());
		query=query.replace("%value2",""+fisa.getMedic().getIdMedicPrimar());
		query=query.replace("%value3", fisa.getDataEmitere());
		
        query=query.replaceAll("''", "null");
		
		connection.insert(query);
		return 0;
	}

	@Override
	public int getIdMedicRezident(int idMedic) throws SQLException {
		int id=0;
		String query="SELECT id_medic_primar_rezident FROM db_info_medic_primar INNER JOIN db_medic_primar on(db_medic_primar.id_medic_primar=db_info_medic_primar.id_medic_primar) where db_medic_primar.id_medic_primar="+idMedic;
		resultSet=connection.select(query);
		
				while(resultSet.next()){
					id=resultSet.getInt(1);
				}
		
		
		return id;
	}

	
	

		
	

}
