package medweb.psconf.daos;

import java.io.Serializable;

/**
 * 
 * @author adi
 *
 */
@SuppressWarnings("serial")
public class Pacient implements Serializable{

	private int idPacient;
	private String nume;
	private String prenume;
	private CategorieAsigurat categorieAsigurat;
	private CasaAsigurari casaAsigurari;
	private MedicPrimar medicPrimar;
	private boolean asigurat;
	private int id_medic;
	private boolean activ;
	/**
	 * @return the idPacient
	 */
	public int getIdPacient() {
		return idPacient;
	}
	/**
	 * @param idPacient the idPacient to set
	 */
	public void setIdPacient(int idPacient) {
		this.idPacient = idPacient;
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
	 * @return the categorieAsigurat
	 */
	public CategorieAsigurat getCategorieAsigurat() {
		return categorieAsigurat;
	}
	/**
	 * @param categorieAsigurat the categorieAsigurat to set
	 */
	public void setCategorieAsigurat(CategorieAsigurat categorieAsigurat) {
		this.categorieAsigurat = categorieAsigurat;
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
	 * @return the medicPrimar
	 */
	public MedicPrimar getMedicPrimar() {
		return medicPrimar;
	}
	/**
	 * @param medicPrimar the medicPrimar to set
	 */
	public void setMedicPrimar(MedicPrimar medicPrimar) {
		this.medicPrimar = medicPrimar;
	}
	/**
	 * @return the asigurat
	 */
	public boolean isAsigurat() {
		return asigurat;
	}
	/**
	 * @param asigurat the asigurat to set
	 */
	public void setAsigurat(boolean asigurat) {
		this.asigurat = asigurat;
	}
	/**
	 * @return the id_medic
	 */
	public int getId_medic() {
		return id_medic;
	}
	/**
	 * @param id_medic the id_medic to set
	 */
	public void setId_medic(int id_medic) {
		this.id_medic = id_medic;
	}
	/**
	 * @return the activ
	 */
	public boolean isActiv() {
		return activ;
	}
	/**
	 * @param activ the activ to set
	 */
	public void setActiv(boolean activ) {
		this.activ = activ;
	}
	
	
}
