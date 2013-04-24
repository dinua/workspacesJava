package medweb.psconf.daos;

import java.io.Serializable;
/**
 * 
 * @author adi
 *
 */
@SuppressWarnings("serial")
public class MedicPrimar implements Serializable{

	private int idMedicPrimar;
	private String nume;
	private String prenume;
	private CabinetMedical cabinetMedical;
	private CasaAsigurari casaAsigurari;
	private int id_cabinet;
	/**
	 * @return the idMedicPrimar
	 */
	public int getIdMedicPrimar() {
		return idMedicPrimar;
	}
	/**
	 * @param idMedicPrimar the idMedicPrimar to set
	 */
	public void setIdMedicPrimar(int idMedicPrimar) {
		this.idMedicPrimar = idMedicPrimar;
	}
	/**
	 * @return the nume
	 */
	public String getNume() {
		return nume;
	}
	/**
	 * @param nume the nume to set
	 */
	public void setNume(String nume) {
		this.nume = nume;
	}
	/**
	 * @return the prenume
	 */
	public String getPrenume() {
		return prenume;
	}
	/**
	 * @param prenume the prenume to set
	 */
	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}
	/**
	 * @return the cabinetMedical
	 */
	public CabinetMedical getCabinetMedical() {
		return cabinetMedical;
	}
	/**
	 * @param cabinetMedical the cabinetMedical to set
	 */
	public void setCabinetMedical(CabinetMedical cabinetMedical) {
		this.cabinetMedical = cabinetMedical;
	}
	/**
	 * @return the casaAsigurari
	 */
	public CasaAsigurari getCasaAsigurari() {
		return casaAsigurari;
	}
	/**
	 * @param casaAsigurari the casaAsigurari to set
	 */
	public void setCasaAsigurari(CasaAsigurari casaAsigurari) {
		this.casaAsigurari = casaAsigurari;
	}
	/**
	 * @return the id_cabinet
	 */
	public int getId_cabinet() {
		return id_cabinet;
	}
	/**
	 * @param id_cabinet the id_cabinet to set
	 */
	public void setId_cabinet(int id_cabinet) {
		this.id_cabinet = id_cabinet;
	}
	
	
}
