package medweb.persistence.help;

import java.sql.ResultSet;
import java.sql.SQLException;

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

public class Conversii {

	private Conversii(){
		
	}
	public static User getUserFromResultSet(ResultSet resultSet) throws SQLException{
		User user=new User();
		
			int id=resultSet.getInt("id_user");
			String username=resultSet.getString("username");
			String password=resultSet.getString("password");
			int activ=resultSet.getShort("activ");
			
			user.setIdUser(id);
			user.setUsername(username);
			user.setPassword(password);
			if(activ==1)
			   user.setActiv(true);
			else
				user.setActiv(false);
			
		
		
		return user;
	}
	public static UserType getUserTypeFromResultSet(ResultSet resultSet) throws SQLException{
		UserType userType=new UserType();
		
			int id=resultSet.getInt("id_tip_user");
			String nume=resultSet.getString("nume_tip_user");
			userType.setIdUserType(id);
			userType.setName(nume);
		
		return userType;
	}
	
	public static Pacient getLightPatientFromResultSet(ResultSet resultSet) throws SQLException{
		Pacient patient=new Pacient();
		
			int id_pacient=resultSet.getInt("id_pacient");
			String nume=resultSet.getString("numePacient");
			String prenume=resultSet.getString("prenumePacient");
			int asigurat=resultSet.getInt("asiguratP");
			patient.setActiv(resultSet.getBoolean("activ"));
			patient.setIdPacient(id_pacient);
			patient.setNume(nume);
			patient.setPrenume(prenume);
			if(asigurat==1)
				patient.setAsigurat(true);
			else
				patient.setAsigurat(false);
			
		
		return patient;
	}
	
	public static Pacient getPacientFromResultSet(ResultSet resultSet) throws SQLException{
		Pacient pacient=new Pacient();
		
			pacient.setIdPacient(resultSet.getInt("id_pacient"));
			pacient.setNume(resultSet.getString("numePacient"));
			pacient.setPrenume(resultSet.getString("prenumePacient"));
			pacient.setActiv(resultSet.getBoolean("activ"));
			CategorieAsigurat categorieAsig=getCategorieAsiguratFromResultSet(resultSet);
			pacient.setCategorieAsigurat(categorieAsig);
			CasaAsigurari casaAsig=getCasaAsigurariFromResultSet(resultSet);
			pacient.setCasaAsigurari(casaAsig);
			int asigurat=resultSet.getInt("asiguratP");
			if(asigurat==1)
				pacient.setAsigurat(true);
			else
				pacient.setAsigurat(false);
			pacient.setId_medic(resultSet.getInt("id_medic_primarP"));
		
		
		return pacient;
	}
	public static PacientInfo getPacientInfoFromResultSet(ResultSet resultSet) throws SQLException{
		PacientInfo info=new PacientInfo();
		
			info.setIdInfoPacient(resultSet.getInt("id_info_pacient"));
			info.setCnp(resultSet.getString("cnp"));
			info.setDataNastere(resultSet.getString("data_nastere"));
			info.setLocNastere(resultSet.getString("loc_nastere"));
			info.setSex(resultSet.getString("sex"));
			info.setGrupaSanguina(resultSet.getString("grupa_sanguina"));
			info.setStareCivila(resultSet.getString("stare_civila"));
			info.setRh(resultSet.getInt("rh"));
			info.setAdresa(resultSet.getString("adresa"));
			info.setCodPostal(resultSet.getString("cod_postal"));
			info.setTelefon(resultSet.getString("telefon"));
			info.setEmail(resultSet.getString("email"));
			info.setSerieBuletin(resultSet.getString("serie_buletin"));
			info.setNrBuletin(resultSet.getString("nr_buletin"));
			info.setNrContractCNAS(resultSet.getString("nr_contract_CNAS"));
			
		
		return info;
	}
	public static CasaAsigurari getCasaAsigurariFromResultSet(ResultSet resultSet) throws SQLException{
		CasaAsigurari casaAsigurari=new CasaAsigurari();
		
		
			casaAsigurari.setIdCasaAsigurari(resultSet.getInt("id_casa_asigurari"));
			casaAsigurari.setNume(resultSet.getString("nume_casa_asig"));
			casaAsigurari.setAdresa(resultSet.getString("adresa_casa_asig"));
			casaAsigurari.setCodFiscal(resultSet.getString("cod_fiscal_casa_asig"));
			casaAsigurari.setContBancar(resultSet.getString("cod_banca_casa_asig"));
			casaAsigurari.setTelefon(resultSet.getString("telefon_casa_asig"));
			casaAsigurari.setEmail(resultSet.getString("email_casa_asig"));
		
		return casaAsigurari;
	}
	
	public static CategorieAsigurat getCategorieAsiguratFromResultSet(ResultSet resultSet) throws SQLException{
		CategorieAsigurat categorieAsigurat=new CategorieAsigurat();
		
			categorieAsigurat.setIdCategorieAsigurat(resultSet.getInt("id_categorie_asigurat"));
			categorieAsigurat.setNume(resultSet.getString("nume_categorie_asigurat"));
		
		return categorieAsigurat;
	}
	
	public static CabinetMedical getCabinetMedicalFromResultSet(ResultSet resultSet) throws SQLException{
		CabinetMedical cabinetMedical =new CabinetMedical();
		
			cabinetMedical.setIdCabinet(resultSet.getInt("id_cabinet_medical"));
			cabinetMedical.setNume(resultSet.getString("numeCabinet"));
			cabinetMedical.setAdresa(resultSet.getString("adresaCabinet"));
			cabinetMedical.setNrContractCNAS(resultSet.getString("nr_contract_CNAS_CM"));
			cabinetMedical.setCodFiscal(resultSet.getString("cod_fiscalCM"));
			CasaAsigurari casaAsig=getCasaAsigurariFromResultSet(resultSet);
			cabinetMedical.setCasaAsigurari(casaAsig);
		
		
		return cabinetMedical;
	}
	public static MedicPrimar getMedicPrimarFromResultSet(ResultSet resultSet) throws SQLException{
		MedicPrimar medicPrimar=new MedicPrimar();
		
			medicPrimar.setIdMedicPrimar(resultSet.getInt("id_medic_primar"));
			medicPrimar.setNume(resultSet.getString("numeMedic"));
			medicPrimar.setPrenume(resultSet.getString("prenumeMedic"));
			CasaAsigurari casaAsig=getCasaAsigurariFromResultSet(resultSet);
			medicPrimar.setCasaAsigurari(casaAsig);
			medicPrimar.setId_cabinet(resultSet.getInt("id_cabinet_medicalMD"));
			
		
		return medicPrimar;
	}
	public static MedicPrimar getMedicPrimarLightFromResultSet(ResultSet resultSet) throws SQLException{
		MedicPrimar medic=new MedicPrimar();
		medic.setIdMedicPrimar(resultSet.getInt("id_medic_primar"));
		medic.setNume(resultSet.getString("numeMedic"));
		medic.setPrenume(resultSet.getString("prenumeMedic"));
		
		return medic;
	}
	public static MedicPrimarInfo getInfoMedicPrimar(ResultSet resultSet) throws SQLException{
		MedicPrimarInfo info=new MedicPrimarInfo();
		
		info.setIdInfoMedicPrimar(resultSet.getInt("id_info_medic_primar"));
		info.setCNP(resultSet.getString("cnp"));
		info.setInitiala(resultSet.getString("initiala"));
		info.setAdresa(resultSet.getString("adresa"));
		info.setTelefon(resultSet.getString("telefon"));
		info.setCodParafa(resultSet.getString("cod_parafa"));
		info.setNrLicenta(resultSet.getString("nr_licenta"));
		info.setNrContractCNAS(resultSet.getString("nr_contract_CNAS"));
		info.setIdMedicRezident(resultSet.getInt("id_medic_primar_rezident"));
		return info;
	}
	public static Orar getOrarFromResultSet(ResultSet resultSet) throws SQLException{
		Orar orar=new Orar();
		orar.setIdOrar(resultSet.getInt("id_orar"));
		orar.setDay1(resultSet.getString("day1"));
		orar.setDay2(resultSet.getString("day2"));
		orar.setDay3(resultSet.getString("day3"));
		orar.setDay4(resultSet.getString("day4"));
		orar.setDay5(resultSet.getString("day5"));
		orar.setDay6(resultSet.getString("day6"));
		orar.setDay7(resultSet.getString("day7"));
		return orar;
	}
	public static Fisa getFisaFromResultSet(ResultSet resultSet) throws SQLException{
		Fisa fisa=new Fisa();
		fisa.setIdFisa(resultSet.getInt("id_fisa"));
		fisa.setDataEmitere(resultSet.getString("data_emiterii"));
		Pacient pacient=getLightPatientFromResultSet(resultSet);
		MedicPrimar medic=getMedicPrimarLightFromResultSet(resultSet);
		fisa.setPacient(pacient);
		fisa.setMedic(medic);
		return fisa;
	}
	public static Consult getConsultFromResultSet(ResultSet resultSet) throws SQLException{
		Consult consult=new Consult();
		consult.setIdConsult(resultSet.getInt("id_consult"));
		consult.setObservatii(resultSet.getString("observatii"));
		consult.setDataConsult(resultSet.getString("data_consult"));
		Fisa fisa=getFisaFromResultSet(resultSet);
		consult.setFisa(fisa);
		return consult;
	}
	public static Medicament getMedicamentFromResultSet(ResultSet resultSet)throws SQLException{
		Medicament medicament=new Medicament();
		
		medicament.setIdMedicament(resultSet.getInt("id_medicament"));
		medicament.setNrSublista(resultSet.getInt("nr_sublista"));
		medicament.setCodAtc(resultSet.getString("cod_atc"));
		medicament.setDenumireInternationala(resultSet.getString("denumire_internationala"));
		medicament.setDenumireComerciala(resultSet.getString("denumire_comerciala"));
		medicament.setFormaF(resultSet.getString("formaF"));
		medicament.setConcentratie(resultSet.getString("concentratie"));
		medicament.setCantAmbalaj(resultSet.getString("cantAmbalaj"));
		
		return medicament;
	}
	public static MedicamentInfo getInfoMedicamentFromResultSet(ResultSet resultSet) throws SQLException{
		MedicamentInfo info=new MedicamentInfo();
		
		info.setIdMedicamentInfo(resultSet.getInt("id_medicament_info"));
		info.setTara(resultSet.getString("tara"));
		info.setFirma(resultSet.getString("firma"));
		info.setPrescriere(resultSet.getString("prescriere"));
		info.setFormaAmbalare(resultSet.getString("forma_ambalare"));
		info.setPretAmanuntulMax(resultSet.getFloat("pret_amanuntul_max"));
		info.setPretAmanuntulMaxUt(resultSet.getFloat("pret_amanuntul_max_ut"));
		info.setValSuprotataCnas(resultSet.getFloat("val_suportata_CNAS"));
		info.setValSuprotataCnasAdulti(resultSet.getFloat("val_suportata_CNAS_adulti"));
		Medicament medicament=getMedicamentFromResultSet(resultSet);
		info.setMedicament(medicament);
		
		return info;
	}
	
	public static Adeverinta getAdeverintaFromResultSet(ResultSet resultSet) throws SQLException{
		Adeverinta adeverinta =new Adeverinta();
		
		adeverinta.setIdAdeverinta(resultSet.getInt("id_adeverinta"));
		adeverinta.setOcupatie(resultSet.getString("ocupatie"));
		adeverinta.setSuferind(resultSet.getString("suferind"));
		adeverinta.setRecomandare1(resultSet.getString("recomandareF"));
		adeverinta.setMotivEliberare(resultSet.getString("motiv_eliberare"));
		adeverinta.setDataEliberarii(resultSet.getString("data_eliberare"));
		adeverinta.setConcluzii(resultSet.getString("concluzii"));
		adeverinta.setRadiologie(resultSet.getString("radiologie"));
		adeverinta.setSerologie(resultSet.getString("serologie"));
		adeverinta.setRecomandare2(resultSet.getString("recomandareV"));
		adeverinta.setApt(resultSet.getString("apt"));
			
		return adeverinta;
	}
	
	public static Reteta getRetetaFromResultSet(ResultSet resultSet) throws SQLException{
		Reteta reteta=new Reteta();
		
		reteta.setIdReteta(resultSet.getInt("id_reteta"));
		reteta.setDataPrescriere(resultSet.getString("data_prescriere"));
		reteta.setUnitateSanitara(resultSet.getString("unitate_sanitara"));
		reteta.setCodFiscalReteta(resultSet.getString("codFiscal_reteta"));
		
		return reteta;
	}
	
	public static RetetaLinie getRetetaLinieFromResultSet(ResultSet resultSet) throws SQLException{
		RetetaLinie linie=new RetetaLinie();
		
		linie.setIdRetetaLinie(resultSet.getInt("id_reteta_linie"));
		linie.setIdReteta(resultSet.getInt("id_retetaL"));
		linie.setCantitate(resultSet.getString("cantitate"));
		linie.setModAdministrare(resultSet.getString("mod_administrare"));
		Medicament medicament=getMedicamentFromResultSet(resultSet);
		linie.setMedicament(medicament);
		
		return linie;
	}
}
