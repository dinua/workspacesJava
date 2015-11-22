package medweb.businessService;

import java.util.List;

import medweb.businessService.exceptions.BusinessSQLException;
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
import medweb.psconf.daos.User;
import medweb.psconf.daos.UserType;

public interface BusinessService {

	User isAUser(String username,String password) throws BusinessSQLException;
	List<User> getAllActivUsers()throws BusinessSQLException;
	List<User> getAllInactivUsers()throws BusinessSQLException;
	void setUserActiv(int idUser) throws BusinessSQLException;
	void setUserInactiv(int idUser) throws BusinessSQLException;
	List<UserType> getAllUserTypes()throws BusinessSQLException;
	UserType getUserTypeByName(String name) throws BusinessSQLException;
	UserType getUserTypeForUser(int idUser) throws BusinessSQLException;
	int saveUser(User user, MedicPrimar medicPrimar,MedicPrimarInfo info) throws BusinessSQLException;
	
	Pacient getPatientByID(int id) throws BusinessSQLException;
	PacientInfo getInfoPacient(Pacient pacient)throws BusinessSQLException;
	List<Pacient> getAllLightPatients()throws BusinessSQLException;
	List<Pacient> getAllActivPatientsForMedic(int idMedic)throws BusinessSQLException  ;
	List<Pacient> getAllInactivPatientsForMedic(int idMedic) throws BusinessSQLException;
	int savePatient(Pacient pacient)throws BusinessSQLException;
	int updatePatient(Pacient pacient)throws BusinessSQLException;
	int savePatientInfo(PacientInfo info)throws BusinessSQLException;
	int updatePatientInfo(PacientInfo info)throws BusinessSQLException;
	void setPatientActiv(int IdPatient)  throws BusinessSQLException;
	void setPatientInactiv(int IdPatient) throws BusinessSQLException;
	void deletePatient(Pacient pacient) throws BusinessSQLException;
	
	List<CasaAsigurari> getAllCasaAsigurari()throws BusinessSQLException;
	List<CategorieAsigurat> getAllCategorieAsigurat()throws BusinessSQLException;
	
	
	CategorieAsigurat getCategorieAsiguratByName(String name)throws BusinessSQLException;
	CasaAsigurari getCasaAsigurariByName(String name)throws BusinessSQLException;
	MedicPrimar getMedicPrimarByID(int id)throws BusinessSQLException;
	
	
	MedicPrimarInfo getInfoMedicPrimar(MedicPrimar medicPrimar)throws BusinessSQLException;
	Orar getOrarMedic(MedicPrimar medicPrimar)throws BusinessSQLException;
	int updateMedicPrimar(MedicPrimar medicPrimar)throws BusinessSQLException;
	int updateMedicPrimarInfo(MedicPrimarInfo medicPrimarInfo)throws BusinessSQLException;
	CabinetMedical getCabinetMedicalByName(String name)throws BusinessSQLException;
	int getIdMedicRezident(int idMedic) throws BusinessSQLException;
	
	List<Consult> getAllConsultatiiForMedic(MedicPrimar medicPrimar)throws BusinessSQLException;
	Fisa getFisaPacinet(int idPacient,int idMedicPrimar)throws BusinessSQLException;
	
	MedicamentInfo getMedicamentInfoById(int idMedicamnet) throws BusinessSQLException;
	List<Medicament> getSublistaMedicamente(int idSublista) throws BusinessSQLException;
	List<Medicament> getAllMedicamente()throws BusinessSQLException;
	Medicament getMedicamentByProperties(String codAtc,String denumireC, int nrSublista)throws BusinessSQLException;
	Medicament getMedicamentByProperties(String codAtc,String denumireC)throws BusinessSQLException;
	
	int saveAdeverinta(Adeverinta adeverinta)throws BusinessSQLException;
	int saveReteta(Reteta reteta) throws BusinessSQLException;
	Adeverinta getAdeverintaByConsultatie(Consult consult) throws BusinessSQLException;
	Reteta getRetetaByConsultatie(Consult consult) throws BusinessSQLException;
}
