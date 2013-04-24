package medweb.businessService.internal;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import medweb.businessService.BusinessService;
import medweb.businessService.exceptions.BusinessSQLException;
import medweb.persitence.PersistenceService;
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

public class BusinessServiceImpl implements BusinessService {

	private final PersistenceService persistenceService;
	private final String SEPARATOR="%";
	public BusinessServiceImpl(PersistenceService ps){
		super();
		this.persistenceService=ps;
	}
	
	@Override
	public User isAUser(String username, String password) throws BusinessSQLException {
		User user=null;
		try {
			user=this.persistenceService.isAUser(username, password);
		} catch (SQLException e) {
			throw new BusinessSQLException(e);
		}
		return user;
	}
	@Override
	public List<User> getAllActivUsers() throws BusinessSQLException {
		List<User> list=null;
		try {
			list=this.persistenceService.getAllActivUsers();
		} catch (SQLException e) {
			throw new BusinessSQLException(e);
		}
		return list;
	}

	@Override
	public List<User> getAllInactivUsers() throws BusinessSQLException {
		List<User> list=null;
		try {
			list=this.persistenceService.getAllInactivUsers();
		} catch (SQLException e) {
			throw new BusinessSQLException(e);
		}
		return list;
	}
	@Override
	public void setUserActiv(int idUser) throws BusinessSQLException {
		try {
			this.persistenceService.setUserActiv(idUser);
		} catch (SQLException e) {
			throw new BusinessSQLException(e);
		}
		
	}

	@Override
	public void setUserInactiv(int idUser) throws BusinessSQLException {
		try {
			this.persistenceService.setUserInactiv(idUser);
		} catch (SQLException e) {
			throw new BusinessSQLException(e);
		}
		
	}

	@Override
	public List<UserType> getAllUserTypes() throws BusinessSQLException {
		List<UserType> list=null;
		try {
			list=this.persistenceService.getAllUserTypes();
		} catch (SQLException e) {
			throw new BusinessSQLException(e);
		}
		return list;
	}

	@Override
	public UserType getUserTypeByName(String name) throws BusinessSQLException {
		UserType type=null;
		try {
			type=this.persistenceService.getUserTypeByName(name);
		} catch (SQLException e) {
			throw new BusinessSQLException(e);
		}
		return type;
	}
	@Override
	public UserType getUserTypeForUser(int idUser) throws BusinessSQLException {
		UserType type=null;
		try {
			type=this.persistenceService.getUserTypeForUser(idUser);
		} catch (SQLException e) {
			throw new BusinessSQLException(e);
		}
		return type;
	}
	@Override
	public int saveUser(User user, MedicPrimar medicPrimar, MedicPrimarInfo info)
			throws BusinessSQLException {
 
		CabinetMedical cabinet=new CabinetMedical();
		cabinet.setIdCabinet(1);
		CasaAsigurari casa=new CasaAsigurari();
		casa.setIdCasaAsigurari(1);
		
      try {
		int idUser=this.persistenceService.saveUser(user);
		medicPrimar.setIdMedicPrimar(idUser);
		medicPrimar.setCabinetMedical(cabinet);
		medicPrimar.setCasaAsigurari(casa);
		this.persistenceService.saveMedicPrimar(medicPrimar);
		info.setMedicPrimar(medicPrimar);
		this.persistenceService.saveMedicPrimarInfo(info);
	} catch (SQLException e) {
		throw new BusinessSQLException(e);
	}
		return medicPrimar.getIdMedicPrimar();
	}
	@Override
	public Pacient getPatientByID(int id) throws BusinessSQLException {
		Pacient pacient=null;
		try {
			pacient=this.persistenceService.getPatientByID(id);
		} catch (SQLException e) {
			throw new BusinessSQLException(e);
		}
		return pacient;
	}
	
	@Override
	public PacientInfo getInfoPacient(Pacient pacient) throws BusinessSQLException {
		PacientInfo info = null;
		try {
			info = this.persistenceService.getInfoPacient(pacient);
		} catch (SQLException e) {
			throw new BusinessSQLException(e);
		}
		
		if(info==null){
			 info=new PacientInfo();
			 info.setRh(-1);
		}
		if(info.getSex()==null){
			info.setSex("M");
		}
		String address=convertAddress(info.getAdresa());
		info.setAdresa(address);
		   return info;
		
	}
	
	@Override
	public List<Pacient> getAllLightPatients() throws BusinessSQLException {
		List<Pacient> list=null;
		try {
			list=this.persistenceService.getAllPatientsLight();
		} catch (SQLException e) {
			throw new BusinessSQLException(e);
		}
		return list;
	}
	
	@Override
	public List<Pacient> getAllActivPatientsForMedic(int idMedic) throws BusinessSQLException {
		List<Pacient> list=null;
		try {
			list=this.persistenceService.getAllActivPatientsForMedic(idMedic);
		} catch (SQLException e) {
			throw new BusinessSQLException(e);
		}
		return list;
	}
	@Override
	public List<Pacient> getAllInactivPatientsForMedic(int idMedic) throws BusinessSQLException {
		List<Pacient> list=null;
		try {
			list=this.persistenceService.getAllInactivPatientsForMedic(idMedic);
		} catch (SQLException e) {
			throw new BusinessSQLException(e);
		}
		return list;
	}
	
	@Override
	public int savePatient(Pacient pacient) throws BusinessSQLException {
		 CategorieAsigurat categorie=getCategorieAsiguratByName(pacient.getCategorieAsigurat().getNume());
		 CasaAsigurari casa=getCasaAsigurariByName(pacient.getCasaAsigurari().getNume());
		 pacient.setCasaAsigurari(casa);
		 pacient.setCategorieAsigurat(categorie);
		 Fisa fisa=new Fisa();
		 fisa.setPacient(pacient);
		 fisa.setMedic(pacient.getMedicPrimar());
		 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	     Date date = new Date();
	     fisa.setDataEmitere(dateFormat.format(date));
		 int idPacient=0;
	     try {
			idPacient= this.persistenceService.savePatient(pacient);
			fisa.getPacient().setIdPacient(idPacient);
			 this.persistenceService.saveFisa(fisa);
		} catch (SQLException e) {
			throw new BusinessSQLException(e);
		}
	     return idPacient;
	}
	@Override
	public int updatePatient(Pacient pacient) throws BusinessSQLException {
		 CategorieAsigurat categorie=getCategorieAsiguratByName(pacient.getCategorieAsigurat().getNume());
		 CasaAsigurari casa=getCasaAsigurariByName(pacient.getCasaAsigurari().getNume());
		 pacient.setCasaAsigurari(casa);
		 pacient.setCategorieAsigurat(categorie);
		try {
			return this.persistenceService.updatePatient(pacient);
		} catch (SQLException e) {
			throw new BusinessSQLException(e);
		}
		
	}
	@Override
	public int savePatientInfo(PacientInfo info) throws BusinessSQLException {
		try {
			return this.persistenceService.savePatientInfo(info);
		} catch (SQLException e) {
			throw new BusinessSQLException(e);
		}
		
	}
	@Override
	public int updatePatientInfo(PacientInfo info)throws BusinessSQLException {
		try {
			return this.persistenceService.updatePatientInfo(info);
		} catch (SQLException e) {
			throw new BusinessSQLException(e);
		}
		
	}
	@Override
	public void deletePatient(Pacient pacient) throws BusinessSQLException {
		try {
			this.persistenceService.deletePatientInfo(pacient);
		} catch (SQLException e) {
			throw new BusinessSQLException(e);
		}
		try {
			this.persistenceService.deletePatient(pacient);
		} catch (SQLException e) {
			throw new BusinessSQLException(e);
		}
		
	}
	@Override
	public void setPatientActiv(int IdPatient)  throws BusinessSQLException{
		try {
			this.persistenceService.setPatientActiv(IdPatient);
		} catch (SQLException e) {
			throw new BusinessSQLException(e);
		}
		
	}

	@Override
	public void setPatientInactiv(int IdPatient)  throws BusinessSQLException{
		try {
			this.persistenceService.setPatientInactiv(IdPatient);
		} catch (SQLException e) {
			throw new BusinessSQLException(e);
		}
		
	}
	@Override
	public List<CasaAsigurari> getAllCasaAsigurari() throws BusinessSQLException {
		try {
			return this.persistenceService.getAllCasaAsigurari();
		} catch (SQLException e) {
			throw new BusinessSQLException(e);
		}
	}
	@Override
	public List<CategorieAsigurat> getAllCategorieAsigurat() throws BusinessSQLException {
		try {
			return this.persistenceService.getAllCategorieAsigurat();
		} catch (SQLException e) {
			throw new BusinessSQLException(e);
		}
	}
	
	@Override
	public CategorieAsigurat getCategorieAsiguratByName(String name) throws BusinessSQLException {
		try {
			return this.persistenceService.getCategorieAsiguratByName(name);
		} catch (SQLException e) {
			throw new BusinessSQLException(e);
		}
	}
	@Override
	public  CasaAsigurari getCasaAsigurariByName(String name) throws BusinessSQLException {
		try {
			return this.persistenceService.getCasaAsigurariByName(name);
		} catch (SQLException e) {
			throw new BusinessSQLException(e);
		}
	}
	@Override
	public MedicPrimar getMedicPrimarByID(int id) throws BusinessSQLException {
		MedicPrimar medicPrimar=null;
		try {
			medicPrimar=this.persistenceService.getMedicPrimarByID(id);
		} catch (SQLException e) {
			throw new BusinessSQLException(e);
		}
		
		if(medicPrimar==null){
			medicPrimar=new MedicPrimar();
		}
		if(medicPrimar.getCabinetMedical()!=null){
			medicPrimar.getCabinetMedical().setAdresa("");
		String adresaCabinet=convertAddress(medicPrimar.getCabinetMedical().getAdresa());
		medicPrimar.getCabinetMedical().setAdresa(adresaCabinet);
		}
		return medicPrimar;
	}
	
	@Override
	public MedicPrimarInfo getInfoMedicPrimar(MedicPrimar medicPrimar) throws BusinessSQLException {
		MedicPrimarInfo info=null;
		try {
			info=this.persistenceService.getInfoMedicPrimar(medicPrimar);
		} catch (SQLException e) {
			throw new BusinessSQLException(e);
		}
		
		if(info==null)
			info=new MedicPrimarInfo();
		if(info.getAdresa()==null)
			info.setAdresa("");
		if(info.getCNP()==null)
			info.setCNP("");
		if(info.getCodParafa()==null)
			info.setCodParafa("");
		if(info.getInitiala()==null)
			info.setInitiala("");
		if(info.getNrContractCNAS()==null)
			info.setNrContractCNAS("");
		if(info.getNrLicenta()==null)
			info.setNrLicenta("");
		if(info.getTelefon()==null)
			info.setTelefon("");
				
		return info;
	}
	@Override
	public Orar getOrarMedic(MedicPrimar medicPrimar) throws BusinessSQLException {
		Orar orar=null;
		try {
			orar= this.persistenceService.getOrarMedic(medicPrimar);
		} catch (SQLException e) {
			throw new BusinessSQLException(e);
		}
		if(orar==null){
			orar=new Orar();
			orar.setDay1("8");
			orar.setDay2("8");
			orar.setDay3("8");
			orar.setDay4("8");
			orar.setDay5("8");
			orar.setDay6("8");
			orar.setDay7("8");
		}
		return orar;
	}
	@Override
	public int updateMedicPrimar(MedicPrimar medicPrimar) throws BusinessSQLException {
		CasaAsigurari casaAsig = null;
		try {
			casaAsig = this.getCasaAsigurariByName(medicPrimar.getCasaAsigurari().getNume());
		} catch (BusinessSQLException e) {
			throw new BusinessSQLException(e);
		}
		CabinetMedical cabinet=this.getCabinetMedicalByName(medicPrimar.getCabinetMedical().getNume());
		medicPrimar.setCasaAsigurari(casaAsig);
		medicPrimar.setCabinetMedical(cabinet);
		try {
			return this.persistenceService.updateMedicPrimar(medicPrimar);
		} catch (SQLException e) {
			throw new BusinessSQLException(e);
		}
	}
	@Override
	public int updateMedicPrimarInfo(MedicPrimarInfo medicPrimarInfo) throws BusinessSQLException {
		
		try {
			return this.persistenceService.updateMedicPrimarInfo(medicPrimarInfo);
		} catch (SQLException e) {
			throw new BusinessSQLException(e);
		}
	}
	@Override
	public CabinetMedical getCabinetMedicalByName(String name) throws BusinessSQLException {
		try {
			return this.persistenceService.getCabinetMedicalByName(name);
		} catch (SQLException e) {
			throw new BusinessSQLException(e);
		}
	}
	@Override
	public List<Consult> getAllConsultatiiForMedic(MedicPrimar medicPrimar) throws BusinessSQLException {
		List<Consult> list=null;
		try {
			list= this.persistenceService.getAllConsultatiiForMedic(medicPrimar);
		} catch (SQLException e) {
			throw new BusinessSQLException(e);
		}
		return list;
	}
	
	private String convertAddress(String address){
		if(address==null) 
			address="";
		String[]vec=address.split(SEPARATOR);
		if(vec.length==0) 
			address=" "+SEPARATOR+" "+SEPARATOR+" "+SEPARATOR+" ";
		else if(vec.length==1)
		{
			String app=" "+SEPARATOR+" "+SEPARATOR+" ";
			address=vec[0]+SEPARATOR+app;
		}
		else if(vec.length==2)
		{
			String app=" "+SEPARATOR+" ";
			address=vec[0]+SEPARATOR+vec[1]+SEPARATOR+app;
		}
		else if(vec.length==3)
		{
			String app=SEPARATOR+" "; 
			address=vec[0]+SEPARATOR+vec[1]+"%"+vec[1]+SEPARATOR+app;
		}
		return address;
	}
	@Override
	public Fisa getFisaPacinet(int idPacient, int idMedicPrimar) throws BusinessSQLException {
		Fisa fisa=null;
		try {
			fisa=this.persistenceService.getFisaPacinet(idPacient, idMedicPrimar);
		} catch (SQLException e) {
			throw new BusinessSQLException(e);
		}
		if(fisa==null){
			fisa=new Fisa();
		}
		return fisa;
	}

	@Override
	public MedicamentInfo getMedicamentInfoById(int idMedicamnet) throws BusinessSQLException {
		MedicamentInfo info=null;
		try {
			info=this.persistenceService.getMedicamentInfoById(idMedicamnet);
		} catch (SQLException e) {
			throw new BusinessSQLException(e);
		}
		if(info==null){
			info=new MedicamentInfo();
		}
		return info;
	}

	@Override
	public List<Medicament> getSublistaMedicamente(int idSublista) throws BusinessSQLException {
		List<Medicament> list=null;
		try {
			list=this.persistenceService.getSublistaMedicamente(idSublista);
		} catch (SQLException e) {
			throw new BusinessSQLException(e);
		}
		return list;
	}

	@Override
	public List<Medicament> getAllMedicamente() throws BusinessSQLException {
		List<Medicament> list=null;
		
		try {
			list=this.persistenceService.getAllMedicamente();
		} catch (SQLException e) {
			throw new BusinessSQLException(e);
		}
		
		return list;
	}

	@Override
	public Medicament getMedicamentByProperties(String codAtc,
			String denumireC, int nrSublista) throws BusinessSQLException {
		Medicament medicament=null;
		try {
			medicament=this.persistenceService.getMedicamentByProperties(codAtc, denumireC, nrSublista);
		} catch (SQLException e) {
			throw new BusinessSQLException(e);
		}
		return medicament;
	}
	@Override
	public Medicament getMedicamentByProperties(String codAtc,String denumireC) throws BusinessSQLException {
		Medicament medicament=null;
		try {
			medicament=this.persistenceService.getMedicamentByProperties(codAtc, denumireC);
		} catch (SQLException e) {
			throw new BusinessSQLException(e);
		}
		return medicament;
	}
	@Override
	public int saveAdeverinta(Adeverinta adeverinta) throws BusinessSQLException {
		Consult consult=adeverinta.getConsult();
		consult.setObservatii("");
		try {
			int idConsult=this.persistenceService.saveConsult(consult);
			consult.setIdConsult(idConsult);
			adeverinta.setConsult(consult);
			this.persistenceService.saveAdeverinta(adeverinta);
		} catch (SQLException e) {
			throw new BusinessSQLException(e);
		}
		return 0;
	}

	@Override
	public int saveReteta(Reteta reteta) throws BusinessSQLException {
		Consult consult=reteta.getConsult();
		
		int idConsult;
		try {
			idConsult = this.persistenceService.saveConsult(consult);
			consult.setIdConsult(idConsult);
			reteta.setConsult(consult);
			int idReteta=this.persistenceService.saveReteta(reteta);
			Iterator<RetetaLinie> itReteta=reteta.getListaMedicamente().iterator();
			while(itReteta.hasNext()){
				RetetaLinie linie=itReteta.next();
				linie.setIdReteta(idReteta);
				this.persistenceService.saveRetetaLinie(linie);
			}
			
		} catch (SQLException e) {
			throw new BusinessSQLException(e);
		}
		
		return 0;
	}

	@Override
	public Adeverinta getAdeverintaByConsultatie(Consult consult)
			throws BusinessSQLException {
		Adeverinta adeverinta=null;
		try {
			adeverinta=this.persistenceService.getAdeverintaByConsultatie(consult);
			if(adeverinta!=null){
			if(adeverinta.getOcupatie()==null)
				adeverinta.setOcupatie("");
			if(adeverinta.getApt()==null)
				adeverinta.setApt("");
			if(adeverinta.getSuferind()==null)
				adeverinta.setSuferind("");
			if(adeverinta.getRecomandare1()==null)
				adeverinta.setRecomandare1("");
			if(adeverinta.getMotivEliberare()==null)
				adeverinta.setMotivEliberare("");
			if(adeverinta.getDataEliberarii()==null)
				adeverinta.setDataEliberarii("");
			if(adeverinta.getConcluzii()==null)
				adeverinta.setConcluzii("");
			if(adeverinta.getRadiologie()==null)
				adeverinta.setRadiologie("");
			if(adeverinta.getSerologie()==null)
				adeverinta.setSerologie("");
			if(adeverinta.getRecomandare2()==null)
				adeverinta.setRecomandare2("");
			}
		} catch (SQLException e) {
			throw new BusinessSQLException(e);
		}
		return adeverinta;
	}

	@Override
	public Reteta getRetetaByConsultatie(Consult consult)
			throws BusinessSQLException {
		Reteta reteta=null;
		try {
			reteta=this.persistenceService.getRetetaByConsultatie(consult);
			if(reteta!=null){
			List<RetetaLinie> list=this.persistenceService.getListMedicamenteReteta(reteta.getIdReteta());
			reteta.setListaMedicamente(list);
			}
		} catch (SQLException e) {
			throw new BusinessSQLException(e);
		}
		return reteta;
	}

	@Override
	public int getIdMedicRezident(int idMedic) throws BusinessSQLException {
		int id=0;
		try {
			id=this.persistenceService.getIdMedicRezident(idMedic);
		} catch (SQLException e) {
			throw new BusinessSQLException(e);
		}
		return id;
	}

	

	

	

}
