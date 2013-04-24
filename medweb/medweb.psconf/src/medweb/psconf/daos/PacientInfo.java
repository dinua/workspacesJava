package medweb.psconf.daos;

import java.io.Serializable;

@SuppressWarnings("serial")
public class PacientInfo implements Serializable{
    
	private int idInfoPacient;
	private Pacient pacient;
	private String cnp;
	private String dataNastere;
	private String locNastere;
	private String sex;
	private String grupaSanguina;
	private String stareCivila;
	private int rh;
	private String adresa;
	private String codPostal;
	private String telefon;
	private String email;
	private String serieBuletin;
	private String nrBuletin;
	private String nrContractCNAS;
	/**
	 * @return the pacient
	 */
	public Pacient getPacient() {
		return pacient;
	}
	/**
	 * @param pacient the pacient to set
	 */
	public void setPacient(Pacient pacient) {
		this.pacient = pacient;
	}
	/**
	 * @return the cnp
	 */
	public String getCnp() {
		return cnp;
	}
	/**
	 * @param cnp the cnp to set
	 */
	public void setCnp(String cnp) {
		this.cnp = cnp;
	}
	/**
	 * @return the dataNastere
	 */
	public String getDataNastere() {
		return dataNastere;
	}
	/**
	 * @param dataNastere the dataNastere to set
	 */
	public void setDataNastere(String dataNastere) {
		this.dataNastere = dataNastere;
	}
	/**
	 * @return the locNastere
	 */
	public String getLocNastere() {
		return locNastere;
	}
	/**
	 * @param locNastere the locNastere to set
	 */
	public void setLocNastere(String locNastere) {
		this.locNastere = locNastere;
	}
	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * @return the grupaSanguina
	 */
	public String getGrupaSanguina() {
		return grupaSanguina;
	}
	/**
	 * @param grupaSanguina the grupaSanguina to set
	 */
	public void setGrupaSanguina(String grupaSanguina) {
		this.grupaSanguina = grupaSanguina;
	}
	/**
	 * @return the stareCivila
	 */
	public String getStareCivila() {
		return stareCivila;
	}
	/**
	 * @param stareCivila the stareCivila to set
	 */
	public void setStareCivila(String stareCivila) {
		this.stareCivila = stareCivila;
	}
	/**
	 * @return the rh
	 */
	public int getRh() {
		return rh;
	}
	/**
	 * @param rh the rh to set
	 */
	public void setRh(int rh) {
		this.rh = rh;
	}
	/**
	 * @return the adresa
	 */
	public String getAdresa() {
		return adresa;
	}
	/**
	 * @param adresa the adresa to set
	 */
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	/**
	 * @return the codPostal
	 */
	public String getCodPostal() {
		return codPostal;
	}
	/**
	 * @param codPostal the codPostal to set
	 */
	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}
	/**
	 * @return the telefon
	 */
	public String getTelefon() {
		return telefon;
	}
	/**
	 * @param telefon the telefon to set
	 */
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the serieBuletin
	 */
	public String getSerieBuletin() {
		return serieBuletin;
	}
	/**
	 * @param serieBuletin the serieBuletin to set
	 */
	public void setSerieBuletin(String serieBuletin) {
		this.serieBuletin = serieBuletin;
	}
	/**
	 * @return the nrBuletin
	 */
	public String getNrBuletin() {
		return nrBuletin;
	}
	/**
	 * @param nrBuletin the nrBuletin to set
	 */
	public void setNrBuletin(String nrBuletin) {
		this.nrBuletin = nrBuletin;
	}
	/**
	 * @return the nrContractCNAS
	 */
	public String getNrContractCNAS() {
		return nrContractCNAS;
	}
	/**
	 * @param nrContractCNAS the nrContractCNAS to set
	 */
	public void setNrContractCNAS(String nrContractCNAS) {
		this.nrContractCNAS = nrContractCNAS;
	}
	/**
	 * @return the idInfoPacient
	 */
	public int getIdInfoPacient() {
		return idInfoPacient;
	}
	/**
	 * @param idInfoPacient the idInfoPacient to set
	 */
	public void setIdInfoPacient(int idInfoPacient) {
		this.idInfoPacient = idInfoPacient;
	}
	
	
}
