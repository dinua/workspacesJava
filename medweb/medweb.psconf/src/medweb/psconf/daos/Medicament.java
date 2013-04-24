package medweb.psconf.daos;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Medicament implements Serializable {

	private int idMedicament;
	private int nrSublista;
	private String codAtc;
	private String denumireInternationala;
	private String denumireComerciala;
	private String formaF;
	private String concentratie;
	private String cantAmbalaj;
	/**
	 * @return the idMedicament
	 */
	public int getIdMedicament() {
		return idMedicament;
	}
	/**
	 * @param idMedicament the idMedicament to set
	 */
	public void setIdMedicament(int idMedicament) {
		this.idMedicament = idMedicament;
	}
	/**
	 * @return the nrSublista
	 */
	public int getNrSublista() {
		return nrSublista;
	}
	/**
	 * @param nrSublista the nrSublista to set
	 */
	public void setNrSublista(int nrSublista) {
		this.nrSublista = nrSublista;
	}
	/**
	 * @return the codAtc
	 */
	public String getCodAtc() {
		return codAtc;
	}
	/**
	 * @param codAtc the codAtc to set
	 */
	public void setCodAtc(String codAtc) {
		this.codAtc = codAtc;
	}
	/**
	 * @return the denumireInternationala
	 */
	public String getDenumireInternationala() {
		return denumireInternationala;
	}
	/**
	 * @param denumireInternationala the denumireInternationala to set
	 */
	public void setDenumireInternationala(String denumireInternationala) {
		this.denumireInternationala = denumireInternationala;
	}
	/**
	 * @return the denumireComerciala
	 */
	public String getDenumireComerciala() {
		return denumireComerciala;
	}
	/**
	 * @param denumireComerciala the denumireComerciala to set
	 */
	public void setDenumireComerciala(String denumireComerciala) {
		this.denumireComerciala = denumireComerciala;
	}
	/**
	 * @return the formaF
	 */
	public String getFormaF() {
		return formaF;
	}
	/**
	 * @param formaF the formaF to set
	 */
	public void setFormaF(String formaF) {
		this.formaF = formaF;
	}
	/**
	 * @return the concentratie
	 */
	public String getConcentratie() {
		return concentratie;
	}
	/**
	 * @param concentratie the concentratie to set
	 */
	public void setConcentratie(String concentratie) {
		this.concentratie = concentratie;
	}
	/**
	 * @return the cantAmbalaj
	 */
	public String getCantAmbalaj() {
		return cantAmbalaj;
	}
	/**
	 * @param cantAmbalaj the cantAmbalaj to set
	 */
	public void setCantAmbalaj(String cantAmbalaj) {
		this.cantAmbalaj = cantAmbalaj;
	}
	
	
}
