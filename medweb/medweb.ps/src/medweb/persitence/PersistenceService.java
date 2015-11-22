package medweb.persitence;

import java.sql.SQLException;
import java.util.List;

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

public interface PersistenceService {


	User isAUser(String username,String password)  throws SQLException;
	List<User> getAllActivUsers()throws SQLException;
	List<User> getAllInactivUsers()throws SQLException;
	void setUserActiv(int idUser) throws SQLException;
	void setUserInactiv(int idUser) throws SQLException;
	List<UserType> getAllUserTypes()throws SQLException;
	UserType getUserTypeByName(String name) throws SQLException;
	UserType getUserTypeForUser(int idUser) throws SQLException;
	int saveUser(User user)throws SQLException;
	
	Pacient getPatientByID(int id)  throws SQLException;
	PacientInfo getInfoPacient(Pacient pacient)  throws SQLException;
	List<Pacient> getAllPatientsLight()  throws SQLException;
	List<Pacient> getAllActivPatientsForMedic(int idMedic)  throws SQLException;
	List<Pacient> getAllInactivPatientsForMedic(int idMedic)  throws SQLException;
	int savePatient(Pacient pacient)  throws SQLException;
	int updatePatient(Pacient pacient)  throws SQLException;
	int savePatientInfo(PacientInfo info)  throws SQLException;
	int updatePatientInfo(PacientInfo info)  throws SQLException;
	void deletePatient(Pacient pacient)  throws SQLException;
	void deletePatientInfo(Pacient pacient)  throws SQLException;
	void setPatientActiv(int IdPatient) throws SQLException;
	void setPatientInactiv(int IdPatient) throws SQLException;
	
	Fisa getFisaPacinet(int idPacient,int idMedicPrimar) throws SQLException;
	
	MedicPrimar getMedicPrimarByID(int id)throws SQLException;
	MedicPrimarInfo getInfoMedicPrimar(MedicPrimar medicPrimar)throws SQLException;
	Orar getOrarMedic(MedicPrimar medicPrimar)throws SQLException;
	int updateMedicPrimar(MedicPrimar medicPrimar)throws SQLException;
	int updateMedicPrimarInfo(MedicPrimarInfo medicPrimarInfo)throws SQLException;
	int saveMedicPrimar(MedicPrimar medicPrimar)throws SQLException;
	int saveMedicPrimarInfo(MedicPrimarInfo info) throws SQLException;
	int getIdMedicRezident(int idMedic) throws SQLException;
	
	List<Consult> getAllConsultatiiForMedic(MedicPrimar medicPrimar)throws SQLException;
		
	CabinetMedical getCabinetMedicalByID(int id)throws SQLException;
	CasaAsigurari getCasaAsigurariByName(String name)throws SQLException;
	CategorieAsigurat getCategorieAsiguratByName(String name)throws SQLException;
	CabinetMedical getCabinetMedicalByName(String name)throws SQLException;
	List<CasaAsigurari> getAllCasaAsigurari()throws SQLException;
	List<CategorieAsigurat> getAllCategorieAsigurat()throws SQLException;
	
	MedicamentInfo getMedicamentInfoById(int idMedicamnet) throws SQLException;
	Medicament getMedicamentByProperties(String codAtc,String denumireC,int nrSublista) throws SQLException;
	Medicament getMedicamentByProperties(String codAtc,String denumireC) throws SQLException;
	List<Medicament> getSublistaMedicamente(int idSublista) throws SQLException;
	List<Medicament> getAllMedicamente()throws SQLException;
	
	
	int saveConsult(Consult consult) throws SQLException;
	int saveAdeverinta(Adeverinta adeverinta) throws SQLException;
	int saveReteta(Reteta reteta) throws SQLException;
	int saveRetetaLinie(RetetaLinie retetaLinie) throws SQLException;
	
	Adeverinta getAdeverintaByConsultatie(Consult consult) throws SQLException;
	Reteta getRetetaByConsultatie(Consult consult) throws SQLException;
	List<RetetaLinie> getListMedicamenteReteta(int idReteta)throws SQLException;
	int saveFisa(Fisa fisa) throws SQLException;
	
}
