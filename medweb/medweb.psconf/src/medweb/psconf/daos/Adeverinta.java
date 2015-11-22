package medweb.psconf.daos;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Adeverinta implements Serializable{

	private int idAdeverinta;
	private Consult consult;
	private String ocupatie;
	private String suferind;
	private String recomandare1;
	private String motivEliberare;
	private String dataEliberarii;
	private String concluzii;
	private String radiologie;
	private String serologie;
	private String recomandare2;
	private String apt;
	/**
	 * @return the idAdeverinta
	 */
	public int getIdAdeverinta() {
		return idAdeverinta;
	}
	/**
	 * @param idAdeverinta the idAdeverinta to set
	 */
	public void setIdAdeverinta(int idAdeverinta) {
		this.idAdeverinta = idAdeverinta;
	}
	/**
	 * @return the consult
	 */
	public Consult getConsult() {
		return consult;
	}
	/**
	 * @param consult the consult to set
	 */
	public void setConsult(Consult consult) {
		this.consult = consult;
	}
	/**
	 * @return the ocupatie
	 */
	public String getOcupatie() {
		return ocupatie;
	}
	/**
	 * @param ocupatie the ocupatie to set
	 */
	public void setOcupatie(String ocupatie) {
		this.ocupatie = ocupatie;
	}
	/**
	 * @return the suferind
	 */
	public String getSuferind() {
		return suferind;
	}
	/**
	 * @param suferind the suferind to set
	 */
	public void setSuferind(String suferind) {
		this.suferind = suferind;
	}
	/**
	 * @return the recomandare1
	 */
	public String getRecomandare1() {
		return recomandare1;
	}
	/**
	 * @param recomandare1 the recomandare1 to set
	 */
	public void setRecomandare1(String recomandare1) {
		this.recomandare1 = recomandare1;
	}
	/**
	 * @return the motivEliberare
	 */
	public String getMotivEliberare() {
		return motivEliberare;
	}
	/**
	 * @param motivEliberare the motivEliberare to set
	 */
	public void setMotivEliberare(String motivEliberare) {
		this.motivEliberare = motivEliberare;
	}
	/**
	 * @return the dataEliberarii
	 */
	public String getDataEliberarii() {
		return dataEliberarii;
	}
	/**
	 * @param dataEliberarii the dataEliberarii to set
	 */
	public void setDataEliberarii(String dataEliberarii) {
		this.dataEliberarii = dataEliberarii;
	}
	/**
	 * @return the concluzii
	 */
	public String getConcluzii() {
		return concluzii;
	}
	/**
	 * @param concluzii the concluzii to set
	 */
	public void setConcluzii(String concluzii) {
		this.concluzii = concluzii;
	}
	/**
	 * @return the radiologie
	 */
	public String getRadiologie() {
		return radiologie;
	}
	/**
	 * @param radiologie the radiologie to set
	 */
	public void setRadiologie(String radiologie) {
		this.radiologie = radiologie;
	}
	/**
	 * @return the serologie
	 */
	public String getSerologie() {
		return serologie;
	}
	/**
	 * @param serologie the serologie to set
	 */
	public void setSerologie(String serologie) {
		this.serologie = serologie;
	}
	/**
	 * @return the recomandare2
	 */
	public String getRecomandare2() {
		return recomandare2;
	}
	/**
	 * @param recomandare2 the recomandare2 to set
	 */
	public void setRecomandare2(String recomandare2) {
		this.recomandare2 = recomandare2;
	}
	/**
	 * @return the apt
	 */
	public String getApt() {
		return apt;
	}
	/**
	 * @param apt the apt to set
	 */
	public void setApt(String apt) {
		this.apt = apt;
	}
	
	
}
